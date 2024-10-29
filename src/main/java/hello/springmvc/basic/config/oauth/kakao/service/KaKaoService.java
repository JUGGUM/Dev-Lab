package hello.springmvc.basic.config.oauth.kakao.service;

import hello.springmvc.basic.config.oauth.kakao.dto.response.KaKaoTokenResponseDto;
import hello.springmvc.basic.config.oauth.kakao.dto.response.KaKaoUserInfoResponseDto;
import io.netty.handler.codec.http.HttpHeaderValues;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service
public class KaKaoService {

    private String clientId;
    private final String KAKAO_AUTH_TOKEN_URL_HOST;
    private final String KAKAO_AUTH_USER_URL_HOST;

    @Autowired
    public KaKaoService(@Value("${kaKao.client_id}") String clientId) {
        this.clientId = clientId;
        KAKAO_AUTH_TOKEN_URL_HOST = "https://kauth.kakao.com";
        KAKAO_AUTH_USER_URL_HOST = "https://kapi.kakao.com";
    }

    public String getAccessTokenFromKaKao(String code) {
        KaKaoTokenResponseDto kakaoTokenResponseDto = WebClient.create(KAKAO_AUTH_TOKEN_URL_HOST)
                .post().uri(uriBuilder -> uriBuilder.scheme("https").path("/oauth/token")
                        .queryParam("grant_type", "authorization_code")
                        .queryParam("client_id", clientId).queryParam("code", code).build(true))
                .header(HttpHeaders.CONTENT_TYPE,
                        HttpHeaderValues.APPLICATION_X_WWW_FORM_URLENCODED.toString()).retrieve()
                //TODO : Custom Exception
                .onStatus(HttpStatusCode::is4xxClientError,
                        clientResponse -> Mono.error(new RuntimeException("Invalid Parameter")))
                .onStatus(HttpStatusCode::is5xxServerError,
                        clientResponse -> Mono.error(new RuntimeException("Internal Server Error")))
                .bodyToMono(KaKaoTokenResponseDto.class)
                // Mono로 응답 Body를 처리 // RequestBody 내용이 json으로 직렬화되어 들어간다.
                .block(); // Mono는 원래 비동기지만 동기 처리로 변환하여 동기적으로 기다렸다가 결과반환

        log.info(" [Kakao Service] Access Token ------> {}",
                kakaoTokenResponseDto.getAccessToken());
        log.info(" [Kakao Service] Refresh Token ------> {}",
                kakaoTokenResponseDto.getRefreshToken());
        //제공 조건: OpenID Connect가 활성화 된 앱의 토큰 발급 요청인 경우 또는 scope에 openid를 포함한 추가 항목 동의 받기 요청을 거친 토큰 발급 요청인 경우
        log.info(" [Kakao Service] Id Token ------> {}", kakaoTokenResponseDto.getIdToken());
        log.info(" [Kakao Service] Scope ------> {}", kakaoTokenResponseDto.getScope());

        return kakaoTokenResponseDto.getAccessToken();
    }

    public KaKaoUserInfoResponseDto getUserInfo(String accessToken) {

        KaKaoUserInfoResponseDto userInfo = WebClient.create(KAKAO_AUTH_USER_URL_HOST)
                .get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .path("/v2/user/me")
                        .build(true))
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken) // access token 인가
                .header(HttpHeaders.CONTENT_TYPE, HttpHeaderValues.APPLICATION_X_WWW_FORM_URLENCODED.toString())
                .retrieve()
                //TODO : Custom Exception
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> Mono.error(new RuntimeException("Invalid Parameter")))
                .onStatus(HttpStatusCode::is5xxServerError, clientResponse -> Mono.error(new RuntimeException("Internal Server Error")))
                .bodyToMono(KaKaoUserInfoResponseDto.class)
                .block();

        log.info("[ Kakao Service ] Auth ID ---> {} ", userInfo.getId());
        log.info("[ Kakao Service ] NickName ---> {} ", userInfo.getKakaoAccount().getProfile().getNickName());
        log.info("[ Kakao Service ] ProfileImageUrl ---> {} ", userInfo.getKakaoAccount().getProfile().getProfileImageUrl());

        return userInfo;
    }
}
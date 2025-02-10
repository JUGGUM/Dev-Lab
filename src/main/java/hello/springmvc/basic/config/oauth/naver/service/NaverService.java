package hello.springmvc.basic.config.oauth.naver.service;

import hello.springmvc.basic.config.oauth.naver.dto.response.NaverTokenResponseDto;
import hello.springmvc.basic.config.oauth.naver.dto.response.NaverUserInfoResponseDto;
import io.netty.handler.codec.http.HttpHeaderValues;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service
public class NaverService {

    @Value("${naver.client_id}")
    private String naverClientId;

    @Value("${naver.client_secret}")
    private String naverClientSecret;

    private final String NAVER_AUTH_TOKEN_URL_HOST = "https://nid.naver.com";
    private final String NAVER_AUTH_USER_URL_HOST = "https://openapi.naver.com";

    public String getAccessToken(String code, String state) {
        NaverTokenResponseDto naverTokenResponseDto = WebClient.create(NAVER_AUTH_TOKEN_URL_HOST)
                .post().uri(uriBuilder -> uriBuilder.scheme("https").path("/oauth2.0/token")
                        .queryParam("grant_type", "authorization_code")
                        .queryParam("client_id", naverClientId)
                        .queryParam("client_secret", naverClientSecret)
                        .queryParam("code", code)
                        .queryParam("state", state).build(true))
                .header(HttpHeaders.CONTENT_TYPE,
                        HttpHeaderValues.APPLICATION_X_WWW_FORM_URLENCODED.toString())
                //TODO : Custom Exception
                .retrieve() // 응답을 받기위한 메소드 mono flux로 비동기 처리
                .onStatus(HttpStatusCode::is4xxClientError,
                        clientResponse -> Mono.error(new RuntimeException("Invalid Parameter")))
                .onStatus(HttpStatusCode::is5xxServerError,
                        clientResponse -> Mono.error(new RuntimeException("Internal Server Error")))
                .bodyToMono(NaverTokenResponseDto.class)
                // Mono로 응답 Body를 처리 // RequestBody 내용이 json으로 직렬화되어 들어간다.
                .block(); // Mono는 원래 비동기지만 동기 처리로 변환하여 동기적으로 기다렸다가 결과반환
        log.info(" [ Naver Service ] Access Token ------> {}",
                naverTokenResponseDto.getAccessToken());
        log.info(" [ Naver Service ] Refresh Token ------> {}",
                naverTokenResponseDto.getRefreshToken());
        return naverTokenResponseDto.getAccessToken();
    }

    public NaverUserInfoResponseDto getUserInfo(String accessToken) {
        NaverUserInfoResponseDto naverUserInfoResponseDto = WebClient.create(
                        NAVER_AUTH_USER_URL_HOST)
                .get().uri(uriBuilder -> uriBuilder.scheme("https").path("/v1/nid/me").build(true))
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken) // access token 인가
                .header(HttpHeaders.CONTENT_TYPE,
                        HttpHeaderValues.APPLICATION_X_WWW_FORM_URLENCODED.toString())
                .retrieve() // 응답을 받기위한 메소드 mono flux로 비동기 처리
                .onStatus(HttpStatusCode::is4xxClientError,
                        clientResponse -> Mono.error(new RuntimeException("Invalid Parameter")))
                .onStatus(HttpStatusCode::is5xxServerError,
                        clientResponse -> Mono.error(new RuntimeException("Internal Server Error")))
                .bodyToMono(NaverUserInfoResponseDto.class)
                .block();

        log.info("[ Naver Service ] Auth ID ---> {} ",
                naverUserInfoResponseDto.getResponse().getId());
        log.info("[ Naver Service ] NickName ---> {} ",
                naverUserInfoResponseDto.getResponse().getNickname());
        log.info("[ Naver Service ] Email ---> {} ",
                naverUserInfoResponseDto.getResponse().getEmail());

        return naverUserInfoResponseDto;
    }
}

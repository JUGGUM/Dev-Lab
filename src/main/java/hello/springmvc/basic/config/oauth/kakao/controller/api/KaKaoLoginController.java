package hello.springmvc.basic.config.oauth.kakao.controller.api;

import hello.springmvc.basic.config.oauth.kakao.dto.response.KaKaoUserInfoResponseDto;
import hello.springmvc.basic.config.oauth.kakao.service.KaKaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class KaKaoLoginController {

    private final KaKaoService kaKaoService;

    @GetMapping("/callback")
    public ResponseEntity<String> callback(@RequestParam("code") String code) {
        String accessToken = kaKaoService.getAccessTokenFromKaKao(code);
        KaKaoUserInfoResponseDto userInfo = kaKaoService.getUserInfo(accessToken);
        //TODO User 로그인 , 또는 회원가입 로직 추가
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
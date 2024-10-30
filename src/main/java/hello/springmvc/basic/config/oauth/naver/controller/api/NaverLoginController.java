package hello.springmvc.basic.config.oauth.naver.controller.api;

import hello.springmvc.basic.config.oauth.kakao.dto.response.KaKaoUserInfoResponseDto;
import hello.springmvc.basic.config.oauth.naver.dto.response.NaverUserInfoResponseDto;
import hello.springmvc.basic.config.oauth.naver.service.NaverService;
import java.util.HashMap;
import java.util.Map;
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
public class NaverLoginController {

    private final NaverService naverService;

    @GetMapping("/login/naver/code")
    public ResponseEntity<String> naverLogin(@RequestParam(name = "code") String code,
            @RequestParam(name = "state") String state) {
        // 1. 인가 코드 받기 -> @RequestParam String code

        // 2. 접근 토큰 발급 요청
        String accessToken = naverService.getAccessToken(code, state);

        // 3. 사용자 정보 받기
        NaverUserInfoResponseDto userInfo = naverService.getUserInfo(accessToken);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

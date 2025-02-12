package hello.springmvc.basic.domain.codeSandBox.controller;

import hello.springmvc.basic.domain.codeSandBox.service.AsyncTestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AsyncTestController {

    private final AsyncTestService asyncTestService;

    /**
     * 즉시 결과값 반환 ex) api 연동을 하는데 해당 api가 시간이 오래 걸릴 경우 사용하면 좋다.
     * 단 , api연동을 통해 받은 response 값이 필요없을 경우
     * **
     *
     * @return
     */
    @GetMapping("/test/async")
    public String asyncTest() {
        asyncTestService.asyncTest();
        return "asyncTest...";
    }

    /***
     * 5초 후에 결과 반환
     * @return
     */
    @GetMapping("/test/sync")
    public String syncTest() {
        asyncTestService.syncTest();
        return "syncTest...";
    }
}
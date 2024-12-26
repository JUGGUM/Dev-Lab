package hello.springmvc.basic.domain.codeSandBox.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AsyncTestService {

    @Async("asyncTestExecutor")
    public void asyncTest() {
        try {
            log.info("before sleep...");
            Thread.sleep(5000);
            log.info("after sleep, asyncTest");
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    public void syncTest() {
        try {
            log.info("before sleep...");
            Thread.sleep(5000);
            log.info("after sleep, syncTest...");
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}

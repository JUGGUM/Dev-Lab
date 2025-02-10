package hello.springmvc.basic.domain.codeSandBox.controller;

import hello.springmvc.basic.config.error.exception.UserInvalidException;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/solution")
@Slf4j
public class ExceptionController {

    @GetMapping("/test")
    public void testEndpoint() {
        int[] array = {1, 8, 3};
        if (array[0] == 1) {
            throw new UserInvalidException("Invalid user");
        }
        log.error(Arrays.toString(array));
    }
}
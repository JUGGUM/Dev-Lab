package hello.springmvc.basic.domain.user.controller;

import hello.springmvc.basic.domain.user.dto.UserRequestDTO;
import hello.springmvc.basic.domain.user.entity.User;
import hello.springmvc.basic.domain.user.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    /**
     * Page 실습
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/users")
    public Page<User> getUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return userService.getUsers(pageRequest);
    }

    /***
     * QueryDSL 실습
     * @param age
     * @return
     */
    @GetMapping("/users/age")
    public List<User> getUsersByAge(@RequestParam int age) {
        return userService.findUsersByAge(age);
    }

    @PostMapping("/user/valid")
    public String createUser(@RequestBody @Valid UserRequestDTO userRequestDTO) {
        // 사용자 생성 로직
        return "사용자 생성 성공!";
    }
}

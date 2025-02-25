package hello.springmvc.basic.domain.login;

import hello.springmvc.basic.config.redis.RedisService;
import jakarta.servlet.http.HttpSession;
import java.time.Duration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final RedisService redisService;
    private final HttpSession session;

    @PostMapping("/login")
    public String login(@RequestParam String userId, Model model) {
        // 로그인 처리 로직
        session.setAttribute("userId", userId);

        // 세션 정보를 Redis에 저장
        redisService.setValues("session:" + session.getId(), userId, Duration.ofMinutes(30));

        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(Model model) {
        String userId = (String) session.getAttribute("userId");
        model.addAttribute("userId", userId);
        return "home";
    }
}

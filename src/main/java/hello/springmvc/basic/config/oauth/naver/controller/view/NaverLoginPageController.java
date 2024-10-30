package hello.springmvc.basic.config.oauth.naver.controller.view;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/naver_login")
public class NaverLoginPageController {
    @Value("${naver.client_id}")
    private String client_id;

    @Value("${naver.client_secret}")
    private String client_secret;

    @Value("${naver.redirect_url}")
    private String redirect_url;

    @GetMapping("/page")
    public String loginPage(Model model) {
        String location = "https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id="+client_id+"&redirect_uri="+redirect_url;
        model.addAttribute("location", location);
        return "naver_login";
    }
}

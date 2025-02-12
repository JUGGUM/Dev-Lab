package hello.springmvc.basic.config.event.email;

import hello.springmvc.basic.config.event.order.OrderCreatedEvent;
import hello.springmvc.basic.config.redis.RedisService;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender emailSender;
    private final RedisService redisService;
    private final EmailProperties emailProperties;

    public void sendEmailMessage(String email) {
        try {
            String code = "ABCD";
            //String code = createCode();
            // 유효시간 설정해서 redis에 저장
            redisService.setDataExpire(code, email, emailProperties.getValidTime());
            MimeMessage message = createMessage(email, code);
            emailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    // 요청된 인증코드로 이메일 인증
    public Long getUserIdByCode(String code) {
        String email = redisService.getData(code); // 입력 받은 인증 코드(key)를 이용해 email(value)을 꺼낸다.
        if (email == null) { // email이 존재하지 않으면, 유효 기간 만료이거나 코드 잘못 입력
            throw new RuntimeException();
        }
/*
        User user = userValidator.checkEmailPresent(email); // 해당 email로 user를 꺼낸다.
        return user.getId();*

 */
        return 123L;
    }


    private MimeMessage createMessage(String email, String code) {
        return emailSender.createMimeMessage();
    }

    @EventListener
    @Order(2)
    public void handleVoucherCreated(OrderCreatedEvent event) {
        // 이메일 알림 전송 로직
        System.out.println("Sending email for order ID: " + event.getOrderId());
    }
}



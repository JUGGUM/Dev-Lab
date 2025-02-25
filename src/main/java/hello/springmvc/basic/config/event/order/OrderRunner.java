package hello.springmvc.basic.config.event.order;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderRunner implements CommandLineRunner {
    // 서버를 실행하면 즉각실행 이러한코드는 운영에는 필요없고 개발이나 테스트에서만 사용
    private final OrderService orderService;

    @Override
    public void run(String... args) throws Exception {
        // 주문 생성 (ID: 123)
        orderService.createOrder(123L);
    }
}

package hello.springmvc.basic.config.event.point;

import hello.springmvc.basic.config.event.order.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
public class PointService {

    @EventListener
    @Order(1)
    public void handleOrderCreated(OrderCreatedEvent event) {
        // 포인트 추가 로직
        System.out.println("Adding points for order ID: " + event.getOrderId());
    }
}
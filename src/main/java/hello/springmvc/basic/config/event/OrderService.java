package hello.springmvc.basic.config.event;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService {

    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public OrderService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }
    public void createOrder(Long orderId) {
        // 주문 생성 로직
        // ...
        log.error("OrderService.createOrder 호출 ==================");
        // 이벤트 발행
        eventPublisher.publishEvent(new OrderCreatedEvent(this, orderId));
    }

    // 주문 상태 변경
    public void changeOrderStatus(Order order, OrderStatus newStatus) {
        order.setStatus(newStatus);
        System.out.println("Order " + order.getId() + " status changed to " + order.getStatus());
    }

    // 주문 상태에 따른 처리
    public void processOrder(Order order) {
        switch (order.getStatus()) {
            case NEW:
                System.out.println("Processing new order: " + order.getId());
                changeOrderStatus(order, OrderStatus.PROCESSING);
                break;
            case PROCESSING:
                System.out.println("Order is being processed: " + order.getId());
                changeOrderStatus(order, OrderStatus.SHIPPED);
                break;
            case SHIPPED:
                System.out.println("Order has been shipped: " + order.getId());
                changeOrderStatus(order, OrderStatus.DELIVERED);
                break;
            case DELIVERED:
                System.out.println("Order has been delivered: " + order.getId());
                break;
            case CANCELED:
                System.out.println("Order has been canceled: " + order.getId());
                break;
            default:
                throw new IllegalArgumentException("Unexpected value: " + order.getStatus());
        }
    }
}

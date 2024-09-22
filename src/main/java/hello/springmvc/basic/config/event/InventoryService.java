package hello.springmvc.basic.config.event;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class InventoryService {

    @Async
    @EventListener
    public void handleOrderCreatedEvent(OrderCreatedEvent event) {
        // 재고 업데이트 로직
        System.out.println("Updating inventory for order " + event.getOrderId());
        // ...
    }
}

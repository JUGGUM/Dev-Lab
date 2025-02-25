package hello.springmvc.basic.config.event.order;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * 이벤트가 동작하는 방법의 예시
 */
@Getter
public class OrderCreatedEvent extends ApplicationEvent {

    private final Long orderId;

    public OrderCreatedEvent(Object source, Long orderId) {
        super(source);
        this.orderId = orderId;
    }
}

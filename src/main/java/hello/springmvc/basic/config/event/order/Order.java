package hello.springmvc.basic.config.event.order;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "orders")
@RequiredArgsConstructor
public class Order {

    @Id
    private Long id;

    private OrderStatus status;

}

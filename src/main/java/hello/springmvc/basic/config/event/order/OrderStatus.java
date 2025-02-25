package hello.springmvc.basic.config.event.order;

public enum OrderStatus {
    NEW,            // 새로운 주문
    PROCESSING,     // 처리 중
    SHIPPED,        // 배송됨
    DELIVERED,      // 배달 완료
    CANCELED        // 취소됨
}

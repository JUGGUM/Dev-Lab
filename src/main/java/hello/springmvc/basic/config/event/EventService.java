package hello.springmvc.basic.config.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

// Event를 생성하는 Publisher
@Slf4j
@Service
@RequiredArgsConstructor
public class EventService {

    // 이벤트를 생성하기 위한 Bean
    private final ApplicationEventPublisher applicationEventPublisher;

    public void publishCustomEvent(final String message) {
        log.info("Pubishing custom event. ");
        DomainEvent customSpringEvent = new DomainEvent(this, "gayoung", 20);
        applicationEventPublisher.publishEvent(customSpringEvent); // 객체를 넘기면 이벤트가 생성
    }
}

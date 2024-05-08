package hello.springmvc.basic.config.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

// Publisher에서 발행된 Event를 사용하는 부분
// Listner를 만들어주기위해서는 ApplicationListener<{Event_Name}>을 상속받아야합니다.
@Slf4j
@Component
public class EventTestListener {
    @EventListener
    public void handleContextStart(DomainEvent event){
        log.info("name = " + event.getName() + ", age = " + event.getAge());
        log.info("Handling context started event.");
    }
}

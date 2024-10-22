package hello.springmvc.basic.codeSandBox.event;

import org.springframework.context.ApplicationEvent;

@FunctionalInterface
public interface ApplicationEventPublisher {

    default void publishEvent(ApplicationEvent event) {
        publishEvent((Object) event);
    }

    void publishEvent(Object event);
    // https://ksh-coding.tistory.com/111 해당문서참고
}
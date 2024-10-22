package hello.springmvc.basic.domain.team;

import org.springframework.context.ApplicationEvent;

@FunctionalInterface
public interface ApplicationEventPublisher {

    default void publishEvent(ApplicationEvent event){
        publishEvent((Object) event);
    }
    void publishEvent(Object event);

}

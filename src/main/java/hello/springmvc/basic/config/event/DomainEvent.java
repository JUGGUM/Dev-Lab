package hello.springmvc.basic.config.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * 이벤트를 발생시키는 publisher 이것을 받아들이는 listener
 * Event모델
 * super로 생성자에게 객체를 전달
 */
@Getter
public class DomainEvent extends ApplicationEvent {

    private final String name;

    private final int age;

    public DomainEvent(Object source, String name, int age) {
        super(source);
        this.name = name;
        this.age = age;
    }
    /*    @Async(EVENT_HANLER_TASK_EXECUTOR)
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void handleJoinEvent(MemberJoinApplicationEvent event) {
        MemberJoinEventPayload payload = MemberJoinEventPayload.from(event);
        notificationMessagingTemplate.sendNotification(clientNameProperties.getSns().getJoin(), payload, null);
    }*/
}
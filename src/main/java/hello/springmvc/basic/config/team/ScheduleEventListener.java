package hello.springmvc.basic.config.team;

import hello.springmvc.basic.config.team.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class ScheduleEventListener {

    private final NotificationService notificationService; // 서비스관련

    /**
     * @TransactionalEventListener 이벤트의 실질적인 발생을 트랜잭션의 종료를 기준으로 삼는다. 이벤트리스너를 사용할때 트랜잭션 기준으로 실행 시점을
     * 정할수있다.
     */
    @Async // 비동기처리 하나의 eventlistener로직에서 여러작업을 수행한다면 고려
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT) // 이것이 핸들러가 됌
    public void createEvent(final ScheduleCreateEvent scheduleCreateEvent) {
        notificationService.createScheduleNotification(scheduleCreateEvent.getTeamPlaceId());
    }
}

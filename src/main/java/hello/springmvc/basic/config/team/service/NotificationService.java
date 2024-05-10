package hello.springmvc.basic.config.team.service;

import hello.springmvc.basic.config.team.ScheduleEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@Transactional
@RequiredArgsConstructor
public class NotificationService {

    /**
     * NotificationService에서는 Event를 받아서 로직을 실행하기 위해
     *
     * @EventListener를 사용하여 이벤트가 발행되면 ApplicationContext에서 해당 메소드를 실행하도록 설정했습니다.
     * @param scheduleEvent
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @TransactionalEventListener
    @Async // 비동기처리 하나의 eventlistener로직에서 여러작업을 수행한다면 고려
    public void createScheduleNotification(final ScheduleEvent scheduleEvent) {
    }
    //  @TransactionalEventListener
    //  이벤트의 실질적인 발생을 트랜잭션의 종료를 기준으로 삼는다.
    //  이벤트리스너를 사용할때 트랜잭션 기준으로 실행 시점을 정할수있다.
}

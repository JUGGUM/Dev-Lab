package hello.springmvc.basic.config.team.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class NotificationService {
    public void createScheduleNotification(Long teamPlaceId) {
        log.warn("ScheduleCreateEvent 호출완료===================");
    }
}

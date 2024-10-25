package hello.springmvc.basic.config.scheduler;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/***
 * Scheduled 실습을 위한 예제
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class SchedulerConfig {

    private final DeviceService deviceService;

    /**
     * fixedRate: 작업 수행시간과 상관없이 일정 주기마다 메소드를 호출하는 것 fixedDelay는 (작업 수행 시간을 포함하여) 작업을 마친 후부터 주기 타이머가
     * 돌아 메소드를 호출 initialDelay: 스케줄러에서 메소드가 등록되자마자 수행하는 것이 아닌 초기 지연시간을 설정 cron: 스케줄러 정규표현식을 사용하여 작업을
     * 예약
     */
    @Scheduled(fixedDelay = 60000)
    public void fixedDelay() {
        deviceService.synchronize();
        log.info("이전Task종료시점으로부터 정의된 시간만큼 지난후 Task를 실행합니다.");
    }

    @Scheduled(fixedDelayString = "1000")
    public void fixedDelayString() {
        log.info("fixedDelay와 같지만 문자열로 값을 표현하겠다.");
    }

    @Scheduled(fixedRate = 1000)
    public void fixedRate() {
        log.info("이전Task시작시점으로부터 정의된 시간만큼 지난후 Task를 실행합니다.");
    }

    @Scheduled(fixedRateString = "1000")
    public void fixedRateString() {
        log.info("fixedRate와 같지만 문자열로 값을 표현하겠다.");
    }

    @Scheduled(fixedRate = 5000, initialDelay = 3000)
    public void initialDelay() {
        log.info("메소드가 등록되자마자 수행하는것이 아닌 초기 지연시간을 설정하는것");
        log.info("3초의 대기시간 후에 5초마다 로그를 출력하는 작업을 스케줄러가 수행");
    }

    @Scheduled(cron = "20 * * * * *")
    public void run() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초");
        log.error("현재 시간은 : " + new Date());
        log.debug("현재 시간은 : " + dateTime);
        log.error("현재 시간은 : " + dateTime.format(formatter));

        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.warn("JDK 1.0부터 사용 : " + dateFormat.format(today));
    }
}

package hello.springmvc.basic;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * 로그가 출력되는 포멧 확인
 * 시간, 로그 레벨, 프로세스 ID, 쓰레드 명, 클래스명, 로그 메시지
 * 로그 레벨 설정을 변경해서 출력 결과를 보자.
 * LEVEL: TRACE > DEBUG > INFO > WARN > ERROR
 * 개발 서버는 debug 출력
 * 운영 서버는 info 출력
 * 시스템 아웃 콘솔에만 출력하는 것이 아니라, 파일이나 네트워크 등, 로그를 별도의 위치에 남길 수 있다. 특히 파
 * 일로 남길 때는 일별, 특정 용량에 따라 로그를 분할하는 것도 가능하다
 * @Slf4j 로 변경
 * @RestController
 * - @Controller의 반환값이 String 이면 뷰 이름으로 인식된다. 그래서 뷰를 찾고 뷰가 렌더링된다.
 * - 반환값으로 뷰를 찾는것이아니라 HTTP메시지 바디에 바로 입력한다.
 */
@RestController
@Slf4j
public class LogTestController {
    // private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        System.out.println("name = " + name);
        // 밑에 log.info 와 비교하면 그냥 얘는 단순히 출력
        // 이렇게 찍어버리면 로깅 단계에 따라 남기는게 아니고 무조건 출력하기때문에 찍으면 안됌
        log.trace("trace log={}", name); // 로컬서버까지 다찍는것
        log.debug("debug log={}", name); // 개발서버에서 보는거다.
        log.info(" info log={}", name); // 중요한 정보다.
        log.warn(" warn log={}", name); // 위험하다.
        log.error("error log={}", name); // 에러다. 확인해야함

        //로그를 사용하지 않아도 a+b 계산 로직이 먼저 실행됨, 이런 방식으로 사용하면 x
        //출력하지않을건데 필요없는 더하기 연산을 실행하게되면 필요없는 resource를 사용하게 된다.
        log.debug("String concat log=" + name);
        return "ok";
    }
}

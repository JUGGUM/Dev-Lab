package hello.springmvc.basic.domain.movie;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class AppRunner implements CommandLineRunner {

    /**
     * CommandLineRunner를 사용하면 애플리케이션이시작될때 특정로직을 실행할수있어서
     * 초기화 작업이나 설정 작업을 쉽게 수행할수있다. 데이터베이스 초기 데이터 삽입
     *
     */

    private final MovieService movieService;

    @Override
    public void run(String... args) throws Exception {
        log.info("영화 검색하기");
        log.info("movieId=1 ------- " + movieService.get(1L));
        log.info("movieId=1 ------- " + movieService.get(1L));
        log.info("movieId=1 ------- " + movieService.get(1L));
    }
}
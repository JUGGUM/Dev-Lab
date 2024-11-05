package hello.springmvc;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaAuditing
@EnableScheduling // 스케줄러 기능 활성화
@EnableBatchProcessing // 배치 기능 활성화
@ConfigurationPropertiesScan // class path 존재하는 모든 ConfigurationProperties Scan(필수❗️)
public class DevLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevLabApplication.class, args);
    }

}

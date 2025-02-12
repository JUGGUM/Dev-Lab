package hello.springmvc.basic.config.async;

import java.util.concurrent.Executor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

    @Bean(name = "asyncTestExecutor")
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(10);
        executor.setBeanName("asyncTestExecutor");
        executor.initialize();
        return executor;
    }

    @Bean(name = "asyncThreadTaskExecutor")
    public Executor asyncThreadTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(8); // 대기타고있는 쓰레드수
        threadPoolTaskExecutor.setMaxPoolSize(8); // 최대쓰레드수
        // 해당 부분은 yaml 파일에서도 설정가능
        threadPoolTaskExecutor.setThreadNamePrefix("g-executor-v1-");
        return threadPoolTaskExecutor;
    }
}

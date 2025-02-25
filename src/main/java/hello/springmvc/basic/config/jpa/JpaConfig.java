package hello.springmvc.basic.config.jpa;

import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

@Configuration
public class JpaConfig {
    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> Optional.of("AdminUser");  // 실제로는 SecurityContext에서 현재 사용자 정보를 가져와야 함
    }
}
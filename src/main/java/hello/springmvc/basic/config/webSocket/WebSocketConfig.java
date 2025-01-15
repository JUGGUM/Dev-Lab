/*
package hello.springmvc.basic.config.webSocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket // 웹소켓사용하도록정의
public class WebSocketConfig implements WebSocketConfigurer {

    // https://velog.io/@yardyard/Spring-WebSocket%EC%9D%84-%EC%9D%B4%EC%9A%A9%ED%95%9C-%EC%B1%84%ED%8C%85-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry
                .addHandler(signalingSocketHandler(), "/room") // 직접 구현한 웹소켓 핸들러 (signalingSocketHandler)를 웹소켓이 연결될 때, Handshake할 주소 (/room)
                .setAllowedOriginPatterns("*"); // 클라이언트에서 웹 소켓 서버에 요청하는 모든 요청을 수락, CORS 방지
        // 웹소켓을 지원하지 않는 브라우저 환경에서도 비슷한 경험을 할 수 있는 기능을 제공
        // todo: 실제 서비스에서는 "*"으로 하면 안된다. 스프링에서 웹소켓을 사용할 때, same-origin만 허용하는 것이 기본정책이다.
    }

    @Bean
    public ChatSocketHandler signalingSocketHandler() { // WebSocketHandler을 웹 소켓 핸들러로 정의
        return new ChatSocketHandler();
    }
}
*/

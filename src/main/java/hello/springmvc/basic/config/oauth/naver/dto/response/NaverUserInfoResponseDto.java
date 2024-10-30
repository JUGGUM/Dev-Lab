package hello.springmvc.basic.config.oauth.naver.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor //역직렬화를 위한 기본 생성자
@JsonIgnoreProperties(ignoreUnknown = true)
public class NaverUserInfoResponseDto {
    @JsonProperty("id")
    private String id;

    @JsonProperty("nickname")
    private String nickName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("mobile")
    private String mobile;

    private NaverUserDetail response;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class NaverUserDetail {
        private String id;
        private String nickname;
        private String name;
        private String email;
    }
}

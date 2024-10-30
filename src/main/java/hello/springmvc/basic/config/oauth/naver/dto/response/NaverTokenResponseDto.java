package hello.springmvc.basic.config.oauth.naver.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NaverTokenResponseDto {
    @JsonProperty("access_token")
    public String accessToken;

    @JsonProperty("refresh_token")
    public String refreshToken;

    @JsonProperty("token_type")
    public String tokenType;

    @JsonProperty("expires_in")
    public Integer expiresIn;
}

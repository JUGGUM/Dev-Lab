package hello.springmvc.basic.domain.user.dto;

import hello.springmvc.basic.domain.user.entity.User;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRequestDTO {
    @NotBlank(message = "이름은 필수입니다")
    @Size(min = 2, max = 20, message = "이름은 2자 이상 20자 이하여야 합니다")
    private String name;

    @NotBlank(message = "사용자 이름은 필수입니다")
    @Size(min = 3, max = 20, message = "사용자 이름은 3자 이상 20자 이하여야 합니다")
    private String username;

    @NotBlank(message = "이메일은 필수입니다")
    @Email(message = "올바른 이메일 형식이 아닙니다")
    private String email;

    @NotBlank(message = "비밀번호는 필수입니다")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$",
            message = "비밀번호는 6자 이상이며, 숫자와 문자를 포함해야 합니다")
    private String password;

    @Past(message = "생년월일은 과거 날짜여야 합니다")
    private LocalDate birthDate;

    @Future(message = "만료일은 미래 날짜여야 합니다")
    private LocalDate expirationDate;

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$",
            message = "올바른 전화번호 형식이 아닙니다 (예: 010-1234-5678)")
    private String phoneNumber;

    // Entity 변환 메서드
    public User toEntity() {
        return User.builder()
                .name(this.name)
                .username(this.username)
                .email(this.email)
                .password(this.password)  // 실제로는 여기서 암호화 처리 필요
                .birthDate(this.birthDate)
                .expirationDate(this.expirationDate)
                .phoneNumber(this.phoneNumber)
                .build();
    }
}
package hello.springmvc.basic.domain.user.entity;

import hello.springmvc.basic.common.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 20, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private LocalDate birthDate;

    @Column
    private LocalDate expirationDate;

    @Column(length = 20)
    private String phoneNumber;

    // 선택적으로 추가할 수 있는 필드들
/*    @Enumerated(EnumType.STRING)
    private UserRole role;*/

    @Column(nullable = false)
    private boolean isActive;

    // 비즈니스 로직 메서드들
    public void updatePassword(String newPassword) {
        this.password = newPassword;
    }

    public void updatePhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void deactivate() {
        this.isActive = false;
    }
}
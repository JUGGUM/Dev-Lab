package hello.springmvc.basic.domain.team.domain.vo;

import hello.springmvc.basic.domain.team.exception.ScheduleTitleBlankException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class Title {

    @Column(name = "title", nullable = false)
    private String value;

    public Title(final String value) {
        validate(value);
        this.value = value;
    }

    private void validate(final String value) {
        if (Objects.isNull(value)) {
            throw new NullPointerException("일정의 제목이 null일 수 없습니다.");
        }

        if (value.isBlank()) {
            throw new ScheduleTitleBlankException();
        }
    }
}
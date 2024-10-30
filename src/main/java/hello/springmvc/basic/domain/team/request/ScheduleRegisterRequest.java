package hello.springmvc.basic.domain.team.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

//Getter 생성자에 관련된 어노테이션이 사라졌다.
public record ScheduleRegisterRequest(
        @NotBlank(message = "제목은 빈 값일 수 없습니다.")
        String title,

        String description,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
        LocalDateTime startDateTime,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
        LocalDateTime endDateTime) {

    public ScheduleRegisterRequest(
            final String title,
            final LocalDateTime startDateTime,
            final LocalDateTime endDateTime) {
        this(title, null, startDateTime, endDateTime);
    }
}
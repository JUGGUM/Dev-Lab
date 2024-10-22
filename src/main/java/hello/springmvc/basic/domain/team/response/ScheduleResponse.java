package hello.springmvc.basic.domain.team.response;

import hello.springmvc.basic.domain.team.Schedule;
import hello.springmvc.basic.domain.team.domain.vo.Span;
import java.time.format.DateTimeFormatter;

public record ScheduleResponse(
        Long id,
        String title,
        String description,
        String startDateTime,
        String endDateTime
) {
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm";

    public static ScheduleResponse from(final Schedule schedule) {
        final Span span = schedule.getSpan();
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
        final String startDateTime = span.getStartDateTime().format(dateTimeFormatter);
        final String endDateTime = span.getEndDateTime().format(dateTimeFormatter);

        return new ScheduleResponse(
                schedule.getId(),
                schedule.getTitle().getValue(),
                schedule.getDescriptionValue(),
                startDateTime,
                endDateTime
        );
    }
}
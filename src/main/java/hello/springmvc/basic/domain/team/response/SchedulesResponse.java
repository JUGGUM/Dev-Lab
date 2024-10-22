package hello.springmvc.basic.domain.team.response;

import hello.springmvc.basic.domain.team.Schedule;
import java.util.List;

public record SchedulesResponse(
        List<ScheduleResponse> schedules
) {
    public static SchedulesResponse of(final List<Schedule> schedules) {
        return new SchedulesResponse(schedules.stream()
                .map(ScheduleResponse::from)
                .toList()
        );
    }
}
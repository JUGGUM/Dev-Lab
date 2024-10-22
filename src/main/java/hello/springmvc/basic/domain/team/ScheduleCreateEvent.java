package hello.springmvc.basic.domain.team;

public class ScheduleCreateEvent extends ScheduleEvent {

    public ScheduleCreateEvent(final Long scheduleId, final Long teamPlaceId) {
        super(scheduleId, teamPlaceId);
    }
}
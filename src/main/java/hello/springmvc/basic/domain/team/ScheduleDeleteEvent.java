package hello.springmvc.basic.domain.team;

public class ScheduleDeleteEvent extends ScheduleEvent {
    public ScheduleDeleteEvent(final Long scheduleId, final Long teamPlaceId) {
        super(scheduleId, teamPlaceId);
    }
}

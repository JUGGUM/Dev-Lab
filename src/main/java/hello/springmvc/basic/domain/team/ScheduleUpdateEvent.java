package hello.springmvc.basic.domain.team;

public class ScheduleUpdateEvent extends ScheduleEvent {

    public ScheduleUpdateEvent(final Long scheduleId, final Long teamPlaceId) {
        super(scheduleId, teamPlaceId);
    }
}
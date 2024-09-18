package hello.springmvc.basic.config.team;

public class ScheduleUpdateEvent extends ScheduleEvent {

    public ScheduleUpdateEvent(final Long scheduleId, final Long teamPlaceId) {
        super(scheduleId, teamPlaceId);
    }
}
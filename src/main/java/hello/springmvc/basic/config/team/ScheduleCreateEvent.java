package hello.springmvc.basic.config.team;

public class ScheduleCreateEvent extends ScheduleEvent {

    public ScheduleCreateEvent(final Long scheduleId, final Long teamPlaceId) {
        super(scheduleId, teamPlaceId);
    }
}
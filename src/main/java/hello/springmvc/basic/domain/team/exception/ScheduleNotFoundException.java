package hello.springmvc.basic.domain.team.exception;

public class ScheduleNotFoundException extends CustomNotFoundException {
    public ScheduleNotFoundException(final Long scheduleId) {
        super(String.format("조회한 일정이 존재하지 않습니다. - request info { schedule_id : %d }", scheduleId));
    }
}
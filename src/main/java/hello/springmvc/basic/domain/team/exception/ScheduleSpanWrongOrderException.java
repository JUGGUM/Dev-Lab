package hello.springmvc.basic.domain.team.exception;

public class ScheduleSpanWrongOrderException extends CustomNotFoundException{
    public ScheduleSpanWrongOrderException() {
        super(String.format("조회한 일정이 존재하지 않습니다. - request info { schedule_id : %d }"));
    }
}

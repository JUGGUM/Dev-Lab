package hello.springmvc.basic.domain.team.exception;

public class ScheduleTitleBlankException extends CustomNotFoundException{

    public ScheduleTitleBlankException() {
        super(String.format("스케줄의타이틀이비어있습니다."));
    }
}

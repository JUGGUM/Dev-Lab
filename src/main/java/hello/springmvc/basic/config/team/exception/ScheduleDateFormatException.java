package hello.springmvc.basic.config.team.exception;

public class ScheduleDateFormatException extends CustomNotFoundException {
    public ScheduleDateFormatException(Exception e) {
        super(String.format("스케줄의타이틀이비어있습니다."));
    }
}

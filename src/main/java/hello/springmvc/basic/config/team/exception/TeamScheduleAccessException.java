package hello.springmvc.basic.config.team.exception;

public class TeamScheduleAccessException extends CustomNotFoundException{
    public TeamScheduleAccessException(final Long scheduleId, final Long teamPlaceId) {
        super(String.format("팀 스케줄에 접근할수가 없습니다. - request info { team_place_id : %d }", teamPlaceId));
    }
}

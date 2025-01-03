package hello.springmvc.basic.domain.team.exception;

public class TeamPlaceNotFoundException extends CustomNotFoundException {

    public TeamPlaceNotFoundException(final Long teamPlaceId) {
        super(String.format("조회한 팀 플레이스가 존재하지 않습니다. - request info { team_place_id : %d }", teamPlaceId));
    }
}
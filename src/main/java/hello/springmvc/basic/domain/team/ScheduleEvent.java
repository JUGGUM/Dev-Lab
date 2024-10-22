package hello.springmvc.basic.domain.team;


import lombok.Getter;

@Getter
public abstract class ScheduleEvent implements DomainEvent<Long> {

    private final Long scheduleId;
    private final Long teamPlaceId;

    protected ScheduleEvent(final Long scheduleId, final Long teamPlaceId) {
        this.scheduleId = scheduleId;
        this.teamPlaceId = teamPlaceId;
    }

    @Override
    public Long getDomainId() {
        return scheduleId;
    }
}
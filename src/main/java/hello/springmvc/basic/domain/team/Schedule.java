package hello.springmvc.basic.domain.team;

import hello.springmvc.basic.domain.team.domain.vo.Description;
import hello.springmvc.basic.domain.team.domain.vo.Span;
import hello.springmvc.basic.domain.team.domain.vo.Title;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private Long teamPlaceId;

    @Embedded
    private Title title;

    @Embedded
    private Description description;

    @Embedded
    private Span span;

    public Schedule(final Long teamPlaceId, final Title title, final Span span) {
        this.teamPlaceId = teamPlaceId;
        this.title = title;
        this.span = span;
        this.description = new Description(null);
    }

    public Schedule(final Long teamPlaceId, final Title title, final Description description, final Span span) {
        this.teamPlaceId = teamPlaceId;
        this.title = title;
        this.description = (description != null) ? description : new Description(null);
        this.span = span;
    }

    public boolean isScheduleOfTeam(final Long teamPlaceId) {
        return Objects.equals(teamPlaceId, this.teamPlaceId);
    }

    public void changeTitle(final String titleValue) {
        this.title = new Title(titleValue);
    }

    public void changeDescription(final String descriptionValue) {
        this.description = new Description(descriptionValue);
    }

    public void changeSpan(final LocalDateTime startDateTime, final LocalDateTime endDateTime) {
        this.span = new Span(startDateTime, endDateTime);
    }

    public boolean hasDescription() {
        return description != null && description.isExist();
    }

    public String getDescriptionValue() {
        if (hasDescription()) {
            return description.getValue();
        }
        return null;
    }

    public LocalDateTime getStartDateTime() {
        return span.getStartDateTime();
    }

    public LocalDateTime getEndDateTime() {
        return span.getEndDateTime();
    }

    public boolean isAllDay() {
        return span.isAllDay();
    }
}
package hello.springmvc.basic.domain.team.domain;

import hello.springmvc.basic.domain.team.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TeamPlace extends BaseEntity {

    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

/*    public static final String UNKNOWN_TEAM_PLACE_NAME = "알수없음";
    public static final TeamPlace UNKNOWN_TEAM_PLACE = new TeamPlace(
            new Name(UNKNOWN_TEAM_PLACE_NAME));

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Name name;

    public TeamPlace(final Name name) {
        this.name = name;
    }

    public String getNameValue() {
        return name.getValue();
    }*/
}
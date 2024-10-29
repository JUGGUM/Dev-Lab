package hello.springmvc.basic.domain.team.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamPlaceRepository extends JpaRepository<TeamPlace, Long> {

    boolean existsById(Long id);
}

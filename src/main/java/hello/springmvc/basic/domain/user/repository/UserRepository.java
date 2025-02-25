package hello.springmvc.basic.domain.user.repository;

import hello.springmvc.basic.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

}

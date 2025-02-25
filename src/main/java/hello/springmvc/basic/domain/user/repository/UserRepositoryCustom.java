package hello.springmvc.basic.domain.user.repository;

import hello.springmvc.basic.domain.user.dto.UserRequestDTO;
import hello.springmvc.basic.domain.user.entity.User;
import java.util.List;

public interface UserRepositoryCustom {
    List<User> findUsersByAge(int age);

}

package hello.springmvc.basic.domain.user.service;

import hello.springmvc.basic.domain.user.entity.User;
import hello.springmvc.basic.domain.user.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Page<User> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public List<User> findUsersByAge(int age) {
        return userRepository.findUsersByAge(age);
    }
}

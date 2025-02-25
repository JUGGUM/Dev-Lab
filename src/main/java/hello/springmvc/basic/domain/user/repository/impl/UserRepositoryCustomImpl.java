package hello.springmvc.basic.domain.user.repository.impl;

import hello.springmvc.basic.domain.user.entity.User;
import hello.springmvc.basic.domain.user.repository.UserRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

//import static hello.springmvc.basic.domain.user.entity.QUser.user;  // QUser import 추가

@Repository
@RequiredArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    //private final JPAQueryFactory queryFactory;  // 올바른 QueryFactory로 변경

    @Override
    public List<User> findUsersByAge(int age) {
/*        return queryFactory
                .selectFrom(user)
                .where(user.age.eq(age))
                .fetch();*/
        return null;
    }
}

package com.jaetech.user.db;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchException;

import com.jaetech.config.JpaAuditingConfiguration;
import com.jaetech.user.entity.User;
import com.jaetech.user.entity.enums.UserRole;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@DataJpaTest
@Import(value = {JpaAuditingConfiguration.class})
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager em;

    private static User createUser(String nick, String email, UserRole role) {
        return new User(nick, email, role);
    }

    @Test
    void 유저_저장() {
        //given
        User createUser = createUser("test", "test@test.com", UserRole.ADMIN);
        // when
        User savedUser = userRepository.save(createUser);
        // then
        assertThat(createUser.getId()).isGreaterThan(0);
    }

    @Test
    void 유저_id_조회() {
        //given
        User createUser = createUser("test", "test@test.com", UserRole.ADMIN);
        User savedUser = userRepository.save(createUser);
        // when
        em.flush();
        em.clear();
        User foundUser = userRepository.findById(savedUser.getId()).get();
        // then
        assertThat(foundUser.getId()).isEqualTo(savedUser.getId());
    }

    @Test
    void 유저_전체_조회() {
        //given
        User createUser = createUser("test", "test@test.com", UserRole.ADMIN);
        User savedUser = userRepository.save(createUser);
        // when
        em.flush();
        em.clear();
        List<User> users = userRepository.findAll();
        // then
        assertThat(users.size()).isEqualTo(1);
    }

    @Test
    void 유저_삭제() {
        //given
        User createUser = createUser("test", "test@test.com", UserRole.ADMIN);
        User savedUser = userRepository.save(createUser);
        // when
        em.flush();
        em.clear();
        userRepository.deleteById(savedUser.getId());
        // then
        Exception exception = catchException(() -> userRepository.findById(savedUser.getId()).get());
        assertThat(exception.getClass()).isEqualTo(NoSuchElementException.class);
    }
}
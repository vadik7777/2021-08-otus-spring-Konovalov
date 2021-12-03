package ru.otus.homework12.repository;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.otus.homework12.domain.User;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Репозиторий для работы с пользователями должен")
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @DisplayName("получать пользователя по имени")
    @Test
    void shouldCorrectFindByName() {
        val expectedUser = new User(1, "admin", "$2a$12$DccKMGc3RRKY12mW1DVFe.a5qtitu2ex9EmUGxWkVD44T3SsUdnFS");
        val actualUser = userRepository.findByUserName("admin").orElseThrow();
        assertThat(actualUser).usingRecursiveComparison().isEqualTo(expectedUser);
    }
}
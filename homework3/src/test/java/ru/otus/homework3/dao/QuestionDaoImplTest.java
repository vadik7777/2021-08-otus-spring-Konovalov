package ru.otus.homework3.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

@DisplayName("QuestionDaoImpl test")
@SpringBootTest
class QuestionDaoImplTest {

    @Autowired
    private QuestionDao questionDao;

    @DisplayName("shouldCorrectGetAll test")
    @Test
    void shouldCorrectGetAll() {
        assertFalse(questionDao.getAll().isEmpty());
    }
}
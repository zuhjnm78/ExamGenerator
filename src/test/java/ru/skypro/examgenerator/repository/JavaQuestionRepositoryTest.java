package ru.skypro.examgenerator.repository;

import org.junit.jupiter.api.Test;
import ru.skypro.examgenerator.Question.Question;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionRepositoryTest {
    private JavaQuestionRepository javaQuestionRepository = new JavaQuestionRepository();

    @Test
    void testAddQuestion() {
        Question question = new Question("What is Java?", "Java is a programming language.");
        javaQuestionRepository.add(question);

        assertTrue(javaQuestionRepository.getAll().size() == 1);
    }

    @Test
    void testRemoveQuestion() {
        Question question = new Question("What is Java?", "Java is a programming language.");
        javaQuestionRepository.add(question);

        assertEquals(1, javaQuestionRepository.getAll().size());

        javaQuestionRepository.remove(question);

        assertTrue(javaQuestionRepository.getAll().isEmpty());
    }

}
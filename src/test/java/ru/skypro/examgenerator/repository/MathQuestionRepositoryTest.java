package ru.skypro.examgenerator.repository;

import org.junit.jupiter.api.Test;
import ru.skypro.examgenerator.Question.Question;

import static org.junit.jupiter.api.Assertions.*;

class MathQuestionRepositoryTest {
    private MathQuestionRepository mathQuestionRepository = new MathQuestionRepository();

    @Test
    void testAddQuestion() {
        Question question = new Question("What is 2 + 2?", "4");
        mathQuestionRepository.add(question);

        assertTrue(mathQuestionRepository.getAll().size() == 1);
    }

    @Test
    void testRemoveQuestion() {
        Question question = new Question("What is 2 + 2?", "4");
        mathQuestionRepository.add(question);

        assertEquals(1, mathQuestionRepository.getAll().size());

        mathQuestionRepository.remove(question);

        assertTrue(mathQuestionRepository.getAll().isEmpty());
    }


}
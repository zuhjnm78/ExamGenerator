package ru.skypro.examgenerator.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import ru.skypro.examgenerator.Question;

import static org.junit.jupiter.api.Assertions.*;

class MathQuestionServiceTest {
    @InjectMocks
    private MathQuestionService mathQuestionService;

    @Test
    void testAddQuestion() {
        mathQuestionService.addQuestion("What is 2 + 2?", "4");

        assertTrue(mathQuestionService.getAllQuestions().size() == 1);
    }

    @Test
    void testRemoveQuestion() {
        Question question = new Question("What is 2 + 2?", "4");
        mathQuestionService.addQuestion(question);

        assertEquals(1, mathQuestionService.getAllQuestions().size());

        mathQuestionService.removeQuestion(question);

        assertTrue(mathQuestionService.getAllQuestions().isEmpty());
    }

    @Test
    void testGetRandomQuestion_Success() {
        Question question = new Question("What is 2 + 2?", "4");
        mathQuestionService.addQuestion(question);

        assertNotNull(mathQuestionService.getRandomQuestion());
    }

    @Test
    void testGetRandomQuestion_EmptyQuestions() {
        assertThrows(RuntimeException.class, () -> mathQuestionService.getRandomQuestion());
    }


}
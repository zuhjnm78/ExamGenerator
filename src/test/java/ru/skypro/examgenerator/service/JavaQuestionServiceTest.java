package ru.skypro.examgenerator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.skypro.examgenerator.Question;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private JavaQuestionService questionService;

    @BeforeEach
    void setUp() {
        questionService = new JavaQuestionService();
    }

    @Test
    void testAddQuestion() {
        Question question = new Question("What is Java?", "Java is a programming language.");
        questionService.addQuestion(question);

        assertEquals(1, questionService.getAllQuestions().size());
    }

    @Test
    void testRemoveQuestion() {
        Question question = new Question("What is Java?", "Java is a programming language.");
        questionService.addQuestion(question);

        assertEquals(1, questionService.getAllQuestions().size());

        questionService.removeQuestion(question);

        assertTrue(questionService.getAllQuestions().isEmpty());
    }

    @Test
    void testGetRandomQuestion_Success() {
        Question question = new Question("What is Java?", "Java is a programming language.");
        questionService.addQuestion(question);

        assertNotNull(questionService.getRandomQuestion());
    }

    @Test
    void testGetRandomQuestion_EmptyQuestions() {
        assertThrows(RuntimeException.class, () -> questionService.getRandomQuestion());
    }

}
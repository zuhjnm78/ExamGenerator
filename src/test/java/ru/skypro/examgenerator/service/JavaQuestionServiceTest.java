package ru.skypro.examgenerator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.skypro.examgenerator.Question;
import ru.skypro.examgenerator.controller.repository.JavaQuestionRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class JavaQuestionServiceTest {
    @Mock
    private JavaQuestionRepository javaQuestionRepository;

    @InjectMocks
    private JavaQuestionService javaQuestionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddQuestion() {
        javaQuestionService.addQuestion("What is Java?", "Java is a programming language.");

        verify(javaQuestionRepository).add(any(Question.class));
    }

    @Test
    void testRemoveQuestion() {
        Question question = new Question("What is Java?", "Java is a programming language.");
        javaQuestionService.addQuestion(question);

        assertEquals(1, javaQuestionService.getAllQuestions().size());

        javaQuestionService.removeQuestion(question);

        assertTrue(javaQuestionService.getAllQuestions().isEmpty());
    }

    @Test
    void testGetRandomQuestion_Success() {
        Question question = new Question("What is Java?", "Java is a programming language.");
        javaQuestionService.addQuestion(question);

        assertNotNull(javaQuestionService.getRandomQuestion());
        assertTrue(javaQuestionService.getAllQuestions().contains(javaQuestionService.getRandomQuestion()));
    }

    @Test
    void testGetRandomQuestion_EmptyQuestions() {
        assertThrows(RuntimeException.class, () -> javaQuestionService.getRandomQuestion());
    }

}
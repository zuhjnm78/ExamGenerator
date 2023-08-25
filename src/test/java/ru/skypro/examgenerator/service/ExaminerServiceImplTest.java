package ru.skypro.examgenerator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.skypro.examgenerator.Question;
import ru.skypro.examgenerator.exception.BadRequestException;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetQuestions_Success() {
        Set<Question> mockQuestions = new HashSet<>();
        for (int i = 1; i <= 10; i++) {
            mockQuestions.add(new Question("Question " + i, "Answer " + i));
        }

        when(questionService.getAllQuestions()).thenReturn(mockQuestions);
        when(questionService.getRandomQuestion()).thenReturn(mockQuestions.iterator().next());

        int amount = 5;
        Set<Question> selectedQuestions = examinerService.getQuestions(amount);

        assertNotNull(selectedQuestions);
        assertEquals(amount, selectedQuestions.size());
        verify(questionService, atLeast(amount)).getRandomQuestion();
    }

    @Test
    void testGetQuestions_NotEnoughQuestions() {
        Set<Question> mockQuestions = new HashSet<>();
        for (int i = 1; i <= 3; i++) {
            mockQuestions.add(new Question("Question " + i, "Answer " + i));
        }

        when(questionService.getAllQuestions()).thenReturn(mockQuestions);

        int amount = 5;
        assertThrows(BadRequestException.class, () -> examinerService.getQuestions(amount));
    }
}
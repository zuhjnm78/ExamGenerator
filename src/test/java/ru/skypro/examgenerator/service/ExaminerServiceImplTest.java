package ru.skypro.examgenerator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.skypro.examgenerator.Question.Question;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExaminerServiceImplTest {
    @Mock
    private QuestionService javaQuestionService;
    @Mock
    private QuestionService mathQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetQuestions_Success() {
        Set<Question> mockJavaQuestions = new HashSet<>();
        for (int i = 1; i <= 5; i++) {
            mockJavaQuestions.add(new Question("Java Question " + i, "Java Answer " + i));
        }

        Set<Question> mockMathQuestions = new HashSet<>();
        for (int i = 1; i <= 5; i++) {
            mockMathQuestions.add(new Question("Math Question " + i, "Math Answer " + i));
        }

        when(javaQuestionService.getRandomQuestion()).thenReturn(mockJavaQuestions.iterator().next());
        when(mathQuestionService.getRandomQuestion()).thenReturn(mockMathQuestions.iterator().next());

        when(javaQuestionService.getAllQuestions()).thenReturn(mockJavaQuestions);
        when(mathQuestionService.getAllQuestions()).thenReturn(mockMathQuestions);

        int amount = 10;
        Set<Question> selectedQuestions = examinerService.getQuestions(amount);

        assertNotNull(selectedQuestions);
        assertEquals(amount, selectedQuestions.size());

        verify(javaQuestionService, atLeast(5)).getRandomQuestion();
        verify(mathQuestionService, atLeast(5)).getRandomQuestion();
    }
}
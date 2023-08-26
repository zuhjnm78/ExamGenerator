package ru.skypro.examgenerator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.skypro.examgenerator.Question;
import ru.skypro.examgenerator.exception.BadRequestException;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
@Service

public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;
    private Random random = new Random();
    @Autowired

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Set<Question> getQuestions(int amount) {
        Set<Question> selectedQuestions = new HashSet<>();

        int javaQuestionCount = amount / 2;
        int mathQuestionCount = amount - javaQuestionCount;

        selectedQuestions.addAll(getRandomQuestionsFromService(javaQuestionService, javaQuestionCount));
        selectedQuestions.addAll(getRandomQuestionsFromService(mathQuestionService, mathQuestionCount));

        return selectedQuestions;
    }

    private Set<Question> getRandomQuestionsFromService(QuestionService questionService, int count) {
        Set<Question> selectedQuestions = new HashSet<>();
        while (selectedQuestions.size() < count) {
            selectedQuestions.add(questionService.getRandomQuestion());
        }
        return selectedQuestions;
    }
}


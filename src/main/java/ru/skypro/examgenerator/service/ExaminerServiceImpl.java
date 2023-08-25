package ru.skypro.examgenerator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.skypro.examgenerator.Question;
import ru.skypro.examgenerator.exception.BadRequestException;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
@Service

public class ExaminerServiceImpl implements ExaminerService {
    private QuestionService questionService;
    private Random random = new Random();
    @Autowired

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Set<Question> getQuestions(int amount) {
        int availableQuestionCount = questionService.getAllQuestions().size();
        if (amount > availableQuestionCount) {
            throw new BadRequestException("Not enough questions available.");
        }

        Set<Question> selectedQuestions = new HashSet<>();
        while (selectedQuestions.size() < amount) {
            selectedQuestions.add(questionService.getRandomQuestion());
        }
        return selectedQuestions;
    }
}


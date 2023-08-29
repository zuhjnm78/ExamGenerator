package ru.skypro.examgenerator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.skypro.examgenerator.Question.Question;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
@Service

public class ExaminerServiceImpl implements ExaminerService {
    private final List<QuestionService> questionServices;
    private Random random = new Random();

    @Autowired
    public ExaminerServiceImpl(List<QuestionService> questionServices) {
        this.questionServices = questionServices;
    }

    @Override
    public Set<Question> getQuestions(int amount) {
        Set<Question> selectedQuestions = new HashSet<>();

        while (selectedQuestions.size() < amount) {
            QuestionService randomQuestionService = questionServices.get(random.nextInt(questionServices.size()));
            selectedQuestions.add(randomQuestionService.getRandomQuestion());
        }

        return selectedQuestions;
    }
}


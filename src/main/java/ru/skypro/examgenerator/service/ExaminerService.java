package ru.skypro.examgenerator.service;

import ru.skypro.examgenerator.Question.Question;

import java.util.Set;

public interface ExaminerService {
    Set<Question> getQuestions(int amount);
}

package ru.skypro.examgenerator.controller.repository;

import ru.skypro.examgenerator.Question;

import java.util.Set;

public interface QuestionRepository {
    void add(Question question);

    void remove(Question question);

    Set<Question> getAll();
}

package ru.skypro.examgenerator.repository;

import ru.skypro.examgenerator.Question.Question;

import java.util.Set;

public interface QuestionRepository {
    void add(Question question);

    void remove(Question question);

    Set<Question> getAll();
}

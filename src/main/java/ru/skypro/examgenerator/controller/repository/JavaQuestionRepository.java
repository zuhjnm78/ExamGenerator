package ru.skypro.examgenerator.controller.repository;

import org.springframework.stereotype.Repository;
import ru.skypro.examgenerator.Question;

import java.util.HashSet;
import java.util.Set;

@Repository("javaQuestionRepository")
public class JavaQuestionRepository implements QuestionRepository {
    private Set<Question> questions = new HashSet<>();

    @Override
    public void add(Question question) {
        questions.add(question);
    }

    @Override
    public void remove(Question question) {
        questions.remove(question);
    }

    @Override
    public Set<Question> getAll() {

        return questions;
    }
}

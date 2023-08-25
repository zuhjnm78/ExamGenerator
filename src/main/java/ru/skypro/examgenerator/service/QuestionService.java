package ru.skypro.examgenerator.service;

import ru.skypro.examgenerator.Question;
import java.util.Set;

public interface QuestionService {
    void addQuestion(Question question);

    void addQuestion(String questionText, String answerText);

    void removeQuestion(Question question);
    Set<Question> getAllQuestions();
    Question getRandomQuestion();
}

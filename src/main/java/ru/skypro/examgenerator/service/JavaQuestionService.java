package ru.skypro.examgenerator.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.skypro.examgenerator.Question;
import ru.skypro.examgenerator.controller.repository.QuestionRepository;

import java.util.*;
@Service("javaQuestionService")
public class JavaQuestionService implements QuestionService {
    private final QuestionRepository javaQuestionRepository;
    private Random random = new Random();

    public JavaQuestionService(@Qualifier("javaQuestionRepository")QuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public void addQuestion(Question question) {
        javaQuestionRepository.add(question);
    }
    @Override
    public void addQuestion(String questionText, String answerText) {
        Question question = new Question(questionText, answerText);
        javaQuestionRepository.add(question);
    }

    @Override
    public void removeQuestion(Question question) {
        javaQuestionRepository.remove(question);
    }

    @Override
    public Set<Question> getAllQuestions() {

        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Set<Question> questions = javaQuestionRepository.getAll();

        if (questions.isEmpty()) {
            throw new RuntimeException("No questions available.");
        }
        int randomIndex = random.nextInt(questions.size());
        return questions.stream().skip(randomIndex).findFirst().orElse(null);
    }
}

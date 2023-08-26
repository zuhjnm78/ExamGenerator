package ru.skypro.examgenerator.service;

import org.springframework.stereotype.Service;
import ru.skypro.examgenerator.Question;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
@Service
public class MathQuestionService implements QuestionService{
    private Set<Question> questions = new HashSet<>();
    private Random random = new Random();

    @Override
    public void addQuestion(Question question) {
        questions.add(question);
    }

    @Override
    public void addQuestion(String questionText, String answerText) {
        Question question = new Question(questionText, answerText);
        questions.add(question);
    }

    @Override
    public void removeQuestion(Question question) {
        questions.remove(question);
    }

    @Override
    public Set<Question> getAllQuestions() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new RuntimeException("No questions available.");
        }
        int randomIndex = random.nextInt(questions.size());
        return questions.stream().skip(randomIndex).findFirst().orElse(null);
    }
}

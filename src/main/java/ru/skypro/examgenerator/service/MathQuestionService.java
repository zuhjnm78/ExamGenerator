package ru.skypro.examgenerator.service;

import org.springframework.stereotype.Service;
import ru.skypro.examgenerator.Question.Question;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class MathQuestionService implements QuestionService {
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
        int operand1 = random.nextInt(101);
        int operand2 = random.nextInt(101);
        String questionText = operand1 + " + " + operand2 + " = ?";
        String answerText = String.valueOf(operand1 + operand2);
        return new Question(questionText, answerText);
    }
}

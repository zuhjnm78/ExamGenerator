package ru.skypro.examgenerator.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import ru.skypro.examgenerator.Question.Question;
import ru.skypro.examgenerator.service.QuestionService;

import java.util.Set;


@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService javaQuestionService;

    public JavaQuestionController(@Qualifier("javaQuestionService")QuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }


    @PostMapping("/add")
    public void addQuestion(@RequestParam String question, @RequestParam String answer) {
        javaQuestionService.addQuestion(question, answer);
    }

    @GetMapping("/remove")
    public void removeQuestion(@RequestParam String question, @RequestParam String answer) {
        javaQuestionService.removeQuestion(new Question(question, answer));
    }

    @GetMapping
    public Set<Question> getAllQuestions() {
        return javaQuestionService.getAllQuestions();
    }

}

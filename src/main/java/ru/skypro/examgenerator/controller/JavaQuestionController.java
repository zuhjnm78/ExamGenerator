package ru.skypro.examgenerator.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.examgenerator.Question;
import ru.skypro.examgenerator.service.QuestionService;

import java.util.Set;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService service;

    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }


    @GetMapping("/add")
    public void addQuestion(@RequestParam String question, @RequestParam String answer) {
        service.addQuestion(new Question(question, answer));
    }

    @GetMapping("/remove")
    public void removeQuestion(@RequestParam String question, @RequestParam String answer) {
        service.removeQuestion(new Question(question, answer));
    }

    @GetMapping
    public Set<Question> getAllQuestions() {
        return service.getAllQuestions();
    }

}

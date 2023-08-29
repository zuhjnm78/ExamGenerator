package ru.skypro.examgenerator.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.skypro.examgenerator.Question.Question;
import ru.skypro.examgenerator.service.QuestionService;

import java.util.Set;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {
    private final QuestionService mathQuestionService;
    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }

    @PostMapping("/add")
    public void addQuestion(@RequestParam String question, @RequestParam String answer) {
        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Method Not Allowed");
    }

    @GetMapping("/remove")
    public void removeQuestion(@RequestParam String question, @RequestParam String answer) {
        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Method Not Allowed");
    }

    @GetMapping
    public Set<Question> getAllQuestions() {

        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Method Not Allowed");
    }
}

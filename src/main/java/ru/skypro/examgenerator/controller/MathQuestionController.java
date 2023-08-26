package ru.skypro.examgenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import ru.skypro.examgenerator.Question;
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
        mathQuestionService.addQuestion(question, answer);
    }

    @GetMapping("/remove")
    public void removeQuestion(@RequestParam String question, @RequestParam String answer) {
        mathQuestionService.removeQuestion(new Question(question, answer));
    }

    @GetMapping
    public Set<Question> getAllQuestions() {
        return mathQuestionService.getAllQuestions();
    }
}

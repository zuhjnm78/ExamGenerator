package ru.skypro.examgenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.examgenerator.Question.Question;
import ru.skypro.examgenerator.service.ExaminerService;

import java.util.Set;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private ExaminerService examinerService;
    @Autowired
    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Set<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}

package com.org.isdb.quizapp.controller;

import com.org.isdb.quizapp.Question;
import com.org.isdb.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public List <Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }
}

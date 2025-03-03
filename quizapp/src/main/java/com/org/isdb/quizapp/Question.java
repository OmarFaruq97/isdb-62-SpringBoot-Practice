package com.org.isdb.quizapp;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String questionTitle;
    private String question1;
    private String question2;
    private String question3;
    private String question4;
    private String rightAnswer;
    private String difficultylevel;
}

package com.org.isdb.quizapp.service;

import com.org.isdb.quizapp.DAO.QuestionDao;
import com.org.isdb.quizapp.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }
}
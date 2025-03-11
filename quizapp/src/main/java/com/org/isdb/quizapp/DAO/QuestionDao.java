package com.org.isdb.quizapp.DAO;

import com.org.isdb.quizapp.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionDao  extends JpaRepository<Question, Integer> {
}

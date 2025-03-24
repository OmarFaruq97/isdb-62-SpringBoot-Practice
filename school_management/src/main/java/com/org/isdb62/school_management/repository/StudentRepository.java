package com.org.isdb62.school_management.repository;

import com.org.isdb62.school_management.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository <Student, Integer> {

}

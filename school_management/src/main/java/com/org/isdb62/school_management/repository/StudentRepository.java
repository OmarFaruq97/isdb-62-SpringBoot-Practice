package com.org.isdb62.school_management.repository;

<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;

import com.org.isdb62.school_management.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{
=======
import com.org.isdb62.school_management.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository <Student, Integer> {
>>>>>>> 3d4a7c14f5d57766d3bb5f7c97d8059c278ad770
}

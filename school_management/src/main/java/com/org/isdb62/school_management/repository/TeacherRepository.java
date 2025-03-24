package com.org.isdb62.school_management.repository;

<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;

import com.org.isdb62.school_management.model.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer>{
=======
import com.org.isdb62.school_management.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository <Teacher, Integer> {
>>>>>>> 3d4a7c14f5d57766d3bb5f7c97d8059c278ad770
}

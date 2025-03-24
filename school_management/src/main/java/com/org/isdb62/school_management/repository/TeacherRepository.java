package com.org.isdb62.school_management.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.org.isdb62.school_management.model.Teacher;
import org.springframework.stereotype.Repository;


@Repository
public interface TeacherRepository extends JpaRepository <Teacher, Integer> {

}

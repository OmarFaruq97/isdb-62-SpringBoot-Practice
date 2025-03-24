package com.org.isdb62.school_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.isdb62.school_management.model.Student;


@Repository
public interface StudentClassRepository extends JpaRepository<Student,Integer> {
}

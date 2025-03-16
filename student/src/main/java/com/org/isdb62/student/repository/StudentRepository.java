package com.org.isdb62.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.org.isdb62.student.model.Student;
import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository <Student, Integer>{
	List<Student> findAllByName(String name);
	List<Student>findAllByNameAndAge(String name, int age);
}

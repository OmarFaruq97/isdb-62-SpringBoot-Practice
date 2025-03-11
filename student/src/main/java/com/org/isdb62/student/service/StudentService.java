package com.org.isdb62.student.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.org.isdb62.student.model.Student;
import com.org.isdb62.student.repository.StudentRepository;

@Service
public class StudentService {
	
	private final StudentRepository repository;
	
	
	public StudentService(StudentRepository repository) {
		this.repository = repository;
	}

	public Student saveStudent(Student student) {
		Student saved = repository.save(student);
		return saved;		
	}	

	public List<Student> getStudents() {
		return repository.findAll();
	}

	public void deleteById(int id) {
		repository.deleteById(id);		
	}
	
	public Student updateStudent(int id, Student studentDetails) {
        Optional<Student> optionalStudent = repository.findById(id);  // CORRECT: Called on an instance, not statically.

	}
	public List<Student> getStudentsByName(String name) {		
		return null;
	}
} 	



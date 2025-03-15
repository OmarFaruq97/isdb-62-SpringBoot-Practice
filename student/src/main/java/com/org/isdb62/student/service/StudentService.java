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
		if (student != null)
			return repository.save(student);
		else
			return null;
	}

	public List<Student> getStudents() {
		return repository.findAll();
	}

	public void deleteById(int id) {
		repository.deleteById(id);
	}

	public Optional<Student> findStudentById(int id) {
		return repository.findById(id);
	}

	public List<Student> getStudentsByName(String name) {
		return repository.findAllByName(name);
	}

} 	



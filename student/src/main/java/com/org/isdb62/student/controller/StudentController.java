package com.org.isdb62.student.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.isdb62.student.model.Student;
import com.org.isdb62.student.service.StudentService;

@RestController
//@CrossOrigin({"http://localhost:8081"})
@RequestMapping(value = "/student")
public class StudentController {
	
	private final StudentService service;
	
	public StudentController(StudentService service) {
		this.service = service;
	}
	
	@PostMapping	
	public Student saveStudent(@RequestBody Student  student) {
		Student saveStudent=service.saveStudent(student);		
		
		return new Student();
	}
	
	@GetMapping
	   public List<Student> getStudents() {
	      return service.getStudents();
	   }
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		service.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable int id,@RequestBody Student student) {
		return service.updateStudent(id, student);		
	}
	

}

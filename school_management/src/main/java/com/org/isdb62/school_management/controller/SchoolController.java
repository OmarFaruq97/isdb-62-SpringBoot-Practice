package com.org.isdb62.school_management.controller;

import com.org.isdb62.school_management.model.Book;
import com.org.isdb62.school_management.model.Student;
import com.org.isdb62.school_management.model.Teacher;

import com.org.isdb62.school_management.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    // Book endpoints
    @GetMapping("/books")
    public List<Book> getBooks() {
        return schoolService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable int id) {
        return schoolService.getBookById(id);
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return schoolService.saveBook(book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable int id) {
        schoolService.deleteBook(id);
    }

    // Teacher endpoints
    @GetMapping("/teachers")
    public List<Teacher> getTeachers() {
        return schoolService.getAllTeachers();
    }

    @GetMapping("/teachers/{id}")
    public Teacher getTeacher(@PathVariable int id) {
        return schoolService.getTeacherById(id);
    }

    @PostMapping("/teachers")
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return schoolService.saveTeacher(teacher);
    }

    @DeleteMapping("/teachers/{id}")
    public void deleteTeacher(@PathVariable int id) {
        schoolService.deleteTeacher(id);
    }

    // Student endpoints
    @GetMapping("/students")
    public List<Student> getStudents() {
        return schoolService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        return schoolService.getStudentById(id);
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        return schoolService.saveStudent(student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable int id) {
        schoolService.deleteStudent(id);
    }

    // Class endpoints
    @GetMapping("/classes")
    public List<Class> getClasses() {
        return schoolService.getAllClasses();
    }

    @GetMapping("/classes/{id}")
    public Class getClass(@PathVariable int id) {
        return schoolService.getClassById(id);
    }

    @PostMapping("/classes")
    public Class createClass(@RequestBody Class clazz) {
        return schoolService.saveClass(clazz);
    }

    @DeleteMapping("/classes/{id}")
    public void deleteClass(@PathVariable int id) {
        schoolService.deleteClass(id);
    }
}

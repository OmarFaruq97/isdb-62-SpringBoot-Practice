package com.org.isdb62.school_management.service;

import com.org.isdb62.school_management.model.Book;
import com.org.isdb62.school_management.model.Student;
import com.org.isdb62.school_management.model.Teacher;
import com.org.isdb62.school_management.repository.BookRepository;
import com.org.isdb62.school_management.repository.ClassRepository;
import com.org.isdb62.school_management.repository.StudentRepository;
import com.org.isdb62.school_management.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class SchoolService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassRepository classRepository;

    // Book CRUD operations
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    // Teacher CRUD operations
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(int id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(int id) {
        teacherRepository.deleteById(id);
    }

    // Student CRUD operations
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    // Class CRUD operations
    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }

    public Class getClassById(int id) {
        return classRepository.findById(id).orElse(null);
    }

    public Class saveClass(Class clazz) {
        return classRepository.save(clazz);
    }

    public void deleteClass(int id) {
        classRepository.deleteById(id);
    }
}

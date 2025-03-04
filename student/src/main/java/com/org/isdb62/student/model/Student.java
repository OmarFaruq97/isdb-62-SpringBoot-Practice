package com.org.isdb62.student.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="student_sb")

public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    private String name;
    private String clazz;
    private int age;
    private String address;
    private LocalDate dob;  
    
    public Student() {}

    // Constructor to initialize the Student object
    public Student(int id, String name, String clazz, int age, String address, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.clazz = clazz;
        this.age = age;
        this.address = address;
        this.dob = dob;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for clazz (class)
    public String getClazz() {
        return clazz;
    }

    // Setter for clazz
    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Setter for address
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter for dob (Date of Birth)
    public LocalDate getDob() {
        return dob;
    }

    // Setter for dob
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

}

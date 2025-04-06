package com.org.isdb62.school_management.model;

import java.time.Instant;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "T_STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable= false, length=15)
    private String name;

    @Column(length = 15, nullable = false)
    private String email;

    @OneToOne
    @JoinColumn(name="clazz", referencedColumnName="id", nullable = false)
    private StudentClass clazz;

    @Column(nullable = false , unique= true, length = 10)
    private int roll;

    @OneToMany (mappedBy="student")
    private List<Book> books;

    @Column(nullable = false, length = 15)
    private String phone;

    @Column(length = 50)
    private String address;

    @Column(nullable = false, length = 6)
    private String gender;

    @Column(nullable = false, length = 30)
    private Instant dob;
}
package com.org.isdb62.school_management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "T_BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(nullable=false, length =100)
    private String name;

    @Column(nullable=false, length =100)
    private String author;

    @Column(nullable=false, length =100)
    private String publisher;

    @OneToOne
    @JoinColumn(name = "clazz",referencedColumnName = "id" , nullable = false)
    // @Transient
    private StudentClass clazz;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
}
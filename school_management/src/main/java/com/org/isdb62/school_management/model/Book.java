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

    @Column(nullable=false, length =25)
    private String name;

    @Column(nullable=false, length =25)
    private String author;

    @Column(nullable=false, length =25)
    private String publisher;

    @OneToOne
    @JoinColumn(name = "class", referencedColumnName = "id", nullable = false)
    private Class clazz;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
}
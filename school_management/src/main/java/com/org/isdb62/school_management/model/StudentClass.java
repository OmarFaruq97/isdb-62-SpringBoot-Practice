package com.org.isdb62.school_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "T_CLASS")
public class StudentClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 50, unique= false)
    private String name;

    @OneToOne
    @JoinColumn(name = "class_teacher", referencedColumnName = "id", nullable = false)
    private Teacher classTeacher;

    @Column(nullable = false, length =  10,unique=true, name = "room_number")
    private Integer roomNumber;
}
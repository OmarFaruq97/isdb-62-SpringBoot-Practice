package com.org.isdb62.school_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "T_CLASS")
public class StudentClass {
<<<<<<< HEAD
=======

>>>>>>> 3d4a7c14f5d57766d3bb5f7c97d8059c278ad770
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, length = 50)
    private String name;

    @OneToOne
    @JoinColumn(name = "class_teacher", referencedColumnName = "id", nullable = false)
    private Teacher classTeacher;

    @Column(nullable = false, length =  100,unique=true, name = "room_number")
    private Integer roomNumber;

}
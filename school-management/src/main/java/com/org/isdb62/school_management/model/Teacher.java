package com.org.isdb62.school_management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "T_TEACHER")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 30, unique = true)
    private String email;

    @Column(nullable = false, length = 10)
    private String gender;

    @Column(length = 100)
    private String address;

    @Column(nullable = false)
    private String phone;

    @Column(name = "joining_date", updatable=false, nullable = false)
    private Instant joiningDate;

    @Column(nullable = false)
    private BigDecimal salary;

    @Column(name = "marital_status")
    private Boolean maritalStatus;
}

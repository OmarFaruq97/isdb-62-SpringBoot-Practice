package com.org.isdb62.school_management.dto;

import java.time.Instant;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StudentDTO {

    private String name;
	private String email;
	private Integer classId;
	private Integer roll;
	private List<Integer> bookIds;
	private String phone;
	private String address;
	private String gender;
	private Instant dob;

    
}

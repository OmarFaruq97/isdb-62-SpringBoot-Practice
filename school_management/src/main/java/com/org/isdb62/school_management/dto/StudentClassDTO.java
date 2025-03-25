package com.org.isdb62.school_management.dto;

import io.micrometer.common.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentClassDTO {

	@NonNull
    private String name;
	@NonNull
	private Integer classTeacherId;
	@NonNull
	private Integer roomNumber;
    
}

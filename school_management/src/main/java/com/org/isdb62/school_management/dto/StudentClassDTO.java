package com.org.isdb62.school_management.dto;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.Size;
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
	@Size(min = 3, max = 3,message = "Name must be between 3 to 30 character")
    private String name;
	@NonNull
	private Integer classTeacherId;
	@NonNull
	private Integer roomNumber;
    
}

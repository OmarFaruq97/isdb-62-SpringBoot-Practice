package com.org.isdb62.mailingPractice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
	public class EmailRequest {
	    private String to;
	    private String subject;
	    private String body;
	}



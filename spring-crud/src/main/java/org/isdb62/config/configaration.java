package org.isdb62.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class configaration {
	 @Bean
	    public ObjectMapper objectMapper() {
		 return new ObjectMapper().registerModule(new JavaTimeModule()); // ✅ Enable Java 8 Date/Time Support
	    }

}

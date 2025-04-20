package com.org.isdb62.dto;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateRequest {
    @Email(message = "Email should be valid")
    private String email;

    private Role role;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}

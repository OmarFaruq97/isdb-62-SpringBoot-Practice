package com.org.isdb62.dto;

import com.org.isdb62.constans.Role;
import jakarta.validation.constraints.Email;


public record UserUpdateRequest(
        @Email(message = "Email should be valid")
        String email,

        Role role,
        String firstName,
        String lastName,
        String phoneNumber
) {
}

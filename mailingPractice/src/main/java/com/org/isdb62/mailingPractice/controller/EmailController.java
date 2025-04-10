package com.org.isdb62.mailingPractice.controller;

import com.org.isdb62.mailingPractice.model.EmailRequest;
import com.org.isdb62.mailingPractice.service.EmailService;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public String welcome() {
        return "This is Spring Boot Mail Sending";
    }

    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request) {
        try {
            emailService.sendEmail(request.getTo(), request.getSubject(), request.getBody());
            return ResponseEntity.ok("Email sent successfully");
        } catch (MessagingException | IOException | GeneralSecurityException e) {
            return ResponseEntity.internalServerError().body("Failed to send email: " + e.getMessage());
        }
    }
}

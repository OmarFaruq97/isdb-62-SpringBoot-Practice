package com.org.isdb62.controller;

import com.org.isdb62.model.EmailRequest;
import com.org.isdb62.service.EmailService;
import com.org.isdb62.utils.EmailServiceUtils;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request) {
        try {
            emailService.sendEmail(request.getTo(), request.getSubject(), request.getBody());
            return ResponseEntity.ok("Email sent successfully");
        } catch (MessagingException | IOException | GeneralSecurityException e) {
            return ResponseEntity.internalServerError().body("Failed to send email: " + e.getMessage());
        }
    }


    @PostMapping(value = "/send-email-attachment", consumes = "multipart/form-data")
    public ResponseEntity<String> sendEmailWithAttachment(@ModelAttribute EmailRequest request, MultipartFile file) {
        try {
            emailService.sendEmailWithAttachment(request.getTo(), request.getSubject(), request.getBody(), file);
            return ResponseEntity.ok("Email with attachment sent successfully");
        } catch (MessagingException | IOException | GeneralSecurityException e) {
            return ResponseEntity.internalServerError().body("Failed to send email: " + e.getMessage());
        }
    }
}

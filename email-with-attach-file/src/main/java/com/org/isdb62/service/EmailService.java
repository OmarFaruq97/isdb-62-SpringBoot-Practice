package com.org.isdb62.service;

import com.org.isdb62.utils.EmailServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private EmailServiceUtils emailServiceUtils;

    public void sendEmail(String to, String subject, String body) {
    }
}

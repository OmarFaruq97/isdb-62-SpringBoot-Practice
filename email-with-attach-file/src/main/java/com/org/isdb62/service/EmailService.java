package com.org.isdb62.service;

import com.org.isdb62.utils.EmailServiceUtils;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Properties;

import static java.awt.SystemColor.text;

@Service
public class EmailService {

    @Autowired
    private EmailServiceUtils emailServiceUtils;

    public void sendEmail(String to, String subject, String body)
        throws MessagingException, IOException, GeneralSecurityException{
        //Get Gmail Service
        Email service = emailServiceUtils.getEmailService();

        //Create Email Content
        Properties properties = new Properties();
        Session session = Session.getDefaultInstance(properties, null);
        MimeMessage email = new MimeMessage(session);

        email.setFrom(new InternetAddress("me")); // "me" is a special value for authorized user
        email.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
        email.setSubject(subject);
        email.setText(text);

        

    }



    public void sendEmailWithAttachment(String to, String subject, String body, MultipartFile file) {
    }
}

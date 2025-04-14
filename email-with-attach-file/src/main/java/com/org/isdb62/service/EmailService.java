package com.org.isdb62.service;

import com.org.isdb62.utils.Email;
import com.org.isdb62.utils.EmailServiceUtils;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import jakarta.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Base64;
import java.util.Properties;

import static java.awt.SystemColor.text;

@Service
public class EmailService {

    @Autowired
    private EmailServiceUtils emailServiceUtil;

    public void sendEmail(String to, String subject, String body)
        throws MessagingException, IOException, GeneralSecurityException{
        //Get Gmail Service
        Email service = emailServiceUtil.getEmailService();

        //Create Email Content
        Properties properties = new Properties();
        Session session = Session.getDefaultInstance(properties, null);
        MimeMessage email = new MimeMessage(session);

        email.setFrom(new InternetAddress("me")); // "me" is a special value for authorized user
        email.addRecipient(RecipientType.TO, new InternetAddress(to));
        email.setSubject(subject);
        email.setText(body);

        //Encode and send the email
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        email.writeTo(buffer);
        byte[] bytes = buffer.toByteArray();
        String encodedEmail = Base64.encodeBase64URLSafeString(bytes);

        Message message = new Message();
        message.setRaw(encodedEmail);
        
        //send the message
        service.users().messages().send("me", message).execute();
    }
    
    // This is send Email with attach file
    public void sendEmailWithAttachment(String to, String subject, String body, MultipartFile file)
    throws MessagingException, IOException, GeneralSecurityException {

        Email service = emailServiceUtil.getEmailService();

        //Create the email content
        Properties properties = new Properties();
        Session session = Session.getDefaultInstance(properties,null);
        

        MimeMessage email = new MimeMessage(session);
        email.setFrom(new InternetAddress("me"));
        email.addRecipient(RecipientType.TO, new InternetAddress(to));
        email.setSubject(subject);

        //Create multipart message
        MimeMultipart multipart = new MimeMultipart();
    }
}

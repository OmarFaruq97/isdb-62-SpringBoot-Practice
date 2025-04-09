package com.org.isdb62.mailingPractice.service;

import com.org.isdb62.mailingPractice.utils.EmailServiceUtils;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Base64;
import java.util.Properties;

@Service
public class EmailService {

    @Autowired
    private EmailServiceUtils emailServiceUtils;

    public void sendEmail(String to, String subject, String bodytext)
        throws MessagingException, IOException, GeneralSecurityException{
//            get Gmail Service
            Gmail service = emailServiceUtils.getGmailService;

//            Create email content
            Properties prop = new Properties();
            Session session = Session.getDefaultInstance(prop,null);
            MimeMessage email = new MimeMessage(session);

            email.setFrom(new InternetAddress("me"));
            email.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
            email.setSubject(subject);
            email.setText(bodytext);

//            Encode and send the Email
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            email.writeTo(buffer);
            byte[] bytes = buffer.toByteArray();
            String encodedEmail =  Base64.encodeBase64URLSafeString(bytes);

            Message message = new Message();
            message.setRaw(encodedEmail);

//            send the message
            service.users().message().send("me", message).execute();

    }
}

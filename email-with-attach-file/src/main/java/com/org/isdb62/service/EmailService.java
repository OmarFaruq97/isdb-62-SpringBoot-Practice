package com.org.isdb62.service;

import com.org.isdb62.utils.EmailServiceUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Properties;

import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMultipart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.client.util.Base64;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;

import jakarta.mail.Message.RecipientType;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EmailService {

    @Autowired
    private EmailServiceUtils emailServiceUtil;

    public void sendEmail(String to, String subject, String body)
            throws MessagingException, IOException, GeneralSecurityException {
        // Get Gmail Service
        Gmail service = emailServiceUtil.getGmailService();

        // Create Email Content
        Properties properties = new Properties();
        Session session = Session.getDefaultInstance(properties, null);
        MimeMessage email = new MimeMessage(session);

        email.setFrom(new InternetAddress("me")); // "me" is a special value for authorized user
        email.addRecipient(RecipientType.TO, new InternetAddress(to));
        email.setSubject(subject);
        email.setText(body);

        // Encode and send the email
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        email.writeTo(buffer);
        byte[] bytes = buffer.toByteArray();
        String encodedEmail = Base64.encodeBase64URLSafeString(bytes);

        Message message = new Message();
        message.setRaw(encodedEmail);

        // send the message
        service.users().messages().send("me", message).execute();
    }

    // This is send Email with attach file
    public void sendEmailWithAttachment(String to, String subject, String body, MultipartFile file)
			throws MessagingException, IOException, GeneralSecurityException {

        Gmail service = emailServiceUtil.getGmailService();

        // Create the email content
        Properties properties = new Properties();
        Session session = Session.getDefaultInstance(properties, null);

        MimeMessage email = new MimeMessage(session);
        email.setFrom(new InternetAddress("me"));
        email.addRecipient(RecipientType.TO, new InternetAddress(to));
        email.setSubject(subject);

        // Create multipart message
        MimeMultipart multipart = new MimeMultipart();

        // Body part
		MimeBodyPart bodyPart = new MimeBodyPart();
		bodyPart.setText(body);
		multipart.addBodyPart(bodyPart);

        // Attachment part
		MimeBodyPart attachmentPart = new MimeBodyPart();
		attachmentPart.setFileName(file.getOriginalFilename());
		attachmentPart.setContent(file.getBytes(), file.getContentType());
		multipart.addBodyPart(attachmentPart);

        // set content to email
        email.setContent(multipart);

       // Convert to Gmail Message
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		email.writeTo(buffer);
		byte[] rawMessage = buffer.toByteArray();
		String encodedEmail = Base64.encodeBase64URLSafeString(rawMessage); 

        Message message = new Message();
		message.setRaw(encodedEmail);

		service.users().messages().send("me", message).execute();

    }
}

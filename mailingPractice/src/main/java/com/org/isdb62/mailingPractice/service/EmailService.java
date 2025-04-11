package com.org.isdb62.mailingPractice.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Base64;
import java.util.Properties;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;
import com.org.isdb62.mailingPractice.utils.EmailServiceUtils;

import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	 @Autowired
	    private EmailServiceUtils emailServiceUtils;

	    public void sendEmail(String to, String subject, String bodyText)
	        throws MessagingException, IOException, GeneralSecurityException{
//	            get Gmail Service
	            Gmail service = emailServiceUtils.getEmailService();

//	            Create email content
	            Properties prop = new Properties();
	            Session session = Session.getDefaultInstance(prop,null);
	            MimeMessage email = new MimeMessage(session);

				email.setFrom(new InternetAddress("me")); // "me" is a special value for authorized user
	            email.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
	            email.setSubject(subject);
	            email.setText(bodyText);

//	            Encode and send the Email
	            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
	            email.writeTo(buffer);
	            byte[] bytes = buffer.toByteArray();
	            String encodedEmail = Base64.getUrlEncoder().encodeToString(bytes); // Corrected line

	            Message message = new Message();
	            message.setRaw(encodedEmail);

//	            send the message
	            service.users().messages().send("me", message).execute(); // also fix typo: message → messages

	    }
}

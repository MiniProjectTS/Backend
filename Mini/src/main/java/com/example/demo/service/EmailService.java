package com.example.demo.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    JavaMailSender javaMailSender;
    public void sendMail(String email, byte[] certificate) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mailMessage = new MimeMessageHelper(message, true);
        mailMessage.setTo(email);
        mailMessage.setSubject("Your Timetable");
        mailMessage.setText("Your Certificate for participant");
        mailMessage.addAttachment("Timetable.pdf", new ByteArrayResource(certificate));
        javaMailSender.send(message);
        System.out.println("Sent");
    }

}

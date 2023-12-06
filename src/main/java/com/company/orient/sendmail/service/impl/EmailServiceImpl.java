package com.company.orient.sendmail.service.impl;

import com.company.orient.sendmail.dto.MailRequestDto;
import com.company.orient.sendmail.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender javaMailSender;
    @Override
    public String sendEmail(MailRequestDto mailRequestDto) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;

        helper = new MimeMessageHelper(message, true);
        helper.setTo(mailRequestDto.getTo());
        helper.setSubject(mailRequestDto.getSubject());
        helper.setText(mailRequestDto.getText(), true);
        javaMailSender.send(message);
        return "The email has been successfully sent!";
    }
}

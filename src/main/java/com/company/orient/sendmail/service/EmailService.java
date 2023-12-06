package com.company.orient.sendmail.service;

import com.company.orient.sendmail.dto.MailRequestDto;
import jakarta.mail.MessagingException;

public interface EmailService {
    String sendEmail(MailRequestDto mailRequestDto) throws MessagingException;
}

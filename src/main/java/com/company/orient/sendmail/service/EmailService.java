package com.company.orient.sendmail.service;

public interface EmailService {
    String sendEmail(String to, String subject, String text);
}

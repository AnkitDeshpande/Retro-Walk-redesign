package com.retrowalk.service;

import com.retrowalk.dtos.EmailDetailDTO;
import jakarta.mail.MessagingException;

public interface EmailService {

    void sendEmail(String to, String subject, String body) throws MessagingException;

    void processEmailMessage(EmailDetailDTO emailDetailDTO) throws MessagingException;

    String generateEmailBody(EmailDetailDTO emailDetailDTO);

    String loadEmailTemplate(String templateName);
}

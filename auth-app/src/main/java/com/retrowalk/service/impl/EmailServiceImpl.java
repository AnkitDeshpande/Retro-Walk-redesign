package com.retrowalk.service.impl;

import com.retrowalk.models.request.EmailDetails;
import com.retrowalk.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;
    @Value("${spring.mail.username}")
    private String emailSender;

    @Override
    @RabbitListener(queues = "${rabbitmq.queue.email.name}")
    public void sendActivationEmail(EmailDetails emailDetails) {

        String token = UUID.randomUUID().toString();
        String expirationTime = LocalDateTime.now().plusHours(24).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String resetPasswordLink = String.format("http://192.168.50.112:5050/api/v1/auth/activate?email=%s&token=%s&expiresAt=%s", emailDetails.getRecipient(), token, expirationTime);

        Context context = new Context();
        context.setVariable("username", emailDetails.getRecipient());
        context.setVariable("resetPasswordLink", resetPasswordLink);

        String activate = templateEngine.process("activate_user.html", context);

        sendHtmlEmail(emailDetails.getRecipient(), emailDetails.getSubject(), activate);

    }

    private void sendHtmlEmail(String to, String subject, String content) {
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setFrom(emailSender);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            javaMailSender.send(message);
            log.info("Activation email sent successfully to {}", to);
        } catch (MessagingException | MailException e) {
            log.error("Failed to send activation email to {}: {}", to, e.getMessage());
            throw new RuntimeException("Failed to send email", e);
        }
    }
}
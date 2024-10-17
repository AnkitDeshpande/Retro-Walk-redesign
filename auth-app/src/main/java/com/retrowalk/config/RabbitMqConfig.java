package com.retrowalk.config;

import com.retrowalk.enums.MailConfigEnum;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class RabbitMqConfig {

    @Value("${rabbitmq.queue.email.name}")
    private String emailQueue;

    @Value("${rabbitmq.exchange.email.name}")
    private String emailExchange;

    @Value("${rabbitmq.binding.email.name}")
    private String emailRoutingKey;

    @Bean
    public Queue emailQueue() {
        return new Queue(emailQueue);
    }

    @Bean
    public TopicExchange emailExchange() {
        return new TopicExchange(emailExchange);
    }

    @Bean
    public Binding emailBinding() {
        return BindingBuilder.bind(emailQueue()).to(emailExchange()).with(emailRoutingKey);
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(MailConfigEnum.HOST.getValue());
        mailSender.setPort(Integer.parseInt(MailConfigEnum.PORT.getValue()));

        mailSender.setUsername(MailConfigEnum.USERNAME.getValue());
        mailSender.setPassword(MailConfigEnum.PASSWORD.getValue());

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", MailConfigEnum.PROTOCOL.getValue());
        props.put("mail.smtp.auth", MailConfigEnum.SMTP_AUTH.getValue());
        props.put("mail.smtp.starttls.enable", MailConfigEnum.STARTTLS_ENABLE.getValue());
        props.put("mail.debug", MailConfigEnum.MAIL_DEBUG.getValue());

        return mailSender;
    }

}
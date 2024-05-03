package com.example.eventms.users.service;

import com.example.eventms.users.dto.EmailDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQListener {

    private static Logger log = LoggerFactory.getLogger(RabbitMQListener.class);

    @Value("${rabbitmq.queue.registration.name}")
    private String queues;

    @Autowired
    protected JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String senderEmail;

    @RabbitListener(queues = "registrationEmail_queue")
    public void sendEmail(EmailDetails emailDetails){
        log.info("Inside send email method :: START");
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(senderEmail);
        mailMessage.setTo(emailDetails.getRecipients());
        mailMessage.setText(emailDetails.getMessageBody());
        mailMessage.setSubject(emailDetails.getSubject());
        javaMailSender.send(mailMessage);
        log.info("Mail sent successfully");

    }
}

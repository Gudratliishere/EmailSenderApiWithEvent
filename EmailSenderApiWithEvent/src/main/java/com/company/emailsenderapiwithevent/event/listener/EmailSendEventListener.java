package com.company.emailsenderapiwithevent.event.listener;

import com.company.emailsenderapiwithevent.entity.Email;
import com.company.emailsenderapiwithevent.event.EmailSendEvent;
import com.company.emailsenderapiwithevent.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
public class EmailSendEventListener
{

    private static final Logger LOG = Logger.getLogger(EmailSendEventListener.class.getName());

    private final JavaMailSender javaMailSender;
    private final EmailRepository emailRepository;

    @EventListener
    public void emailSendEventHandler (EmailSendEvent emailSendEvent)
    {
        Email email = (Email) emailSendEvent.getSource();

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("gudratlicompany@gmail.com");
        simpleMailMessage.setTo(email.getTo());
        simpleMailMessage.setSubject(email.getTopic());
        simpleMailMessage.setText(email.getMessage());

        javaMailSender.send(simpleMailMessage);
        LOG.log(Level.SEVERE, "Email is send");

        emailRepository.save(email);
        LOG.log(Level.SEVERE, "Email: " + email);
    }
}

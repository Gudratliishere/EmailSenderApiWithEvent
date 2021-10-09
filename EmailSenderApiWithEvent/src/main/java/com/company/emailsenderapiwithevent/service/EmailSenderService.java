package com.company.emailsenderapiwithevent.service;

import com.company.emailsenderapiwithevent.entity.Email;
import com.company.emailsenderapiwithevent.event.EmailSendEvent;
import com.company.emailsenderapiwithevent.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class EmailSenderService
{

    private static final Logger LOG = Logger.getLogger(EmailSenderService.class.getName());

    private final EmailRepository emailRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Async
    public void sendEmail (Email email)
    {
        LOG.log(Level.SEVERE, "Email is sending...");
        applicationEventPublisher.publishEvent(new EmailSendEvent(email));
    }

    public List<Email> getLastEmails ()
    {
        return emailRepository.findAll();
    }
}

package com.company.emailsenderapiwithevent;

import com.company.emailsenderapiwithevent.entity.Email;
import com.company.emailsenderapiwithevent.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class EmailSenderApiWithEventApplication
{

    public static void main (String[] args)
    {
        SpringApplication.run(EmailSenderApiWithEventApplication.class, args);
    }

}

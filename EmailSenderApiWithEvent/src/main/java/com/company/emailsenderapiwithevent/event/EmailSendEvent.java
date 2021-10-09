package com.company.emailsenderapiwithevent.event;

import org.springframework.context.ApplicationEvent;

public class EmailSendEvent extends ApplicationEvent
{
    public EmailSendEvent (Object source)
    {
        super(source);
    }
}

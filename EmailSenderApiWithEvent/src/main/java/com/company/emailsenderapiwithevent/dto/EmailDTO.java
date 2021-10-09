package com.company.emailsenderapiwithevent.dto;

import com.company.emailsenderapiwithevent.entity.Email;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmailDTO
{
    private String to;
    private String topic;
    private String message;

    public static EmailDTO of (Email email)
    {
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setTo(email.getTo());
        emailDTO.setTopic(email.getTopic());
        emailDTO.setMessage(email.getMessage());
        return emailDTO;
    }
}

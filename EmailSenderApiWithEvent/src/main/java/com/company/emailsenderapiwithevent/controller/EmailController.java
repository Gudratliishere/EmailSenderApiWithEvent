package com.company.emailsenderapiwithevent.controller;

import com.company.emailsenderapiwithevent.dto.EmailDTO;
import com.company.emailsenderapiwithevent.dto.ResponseDTO;
import com.company.emailsenderapiwithevent.entity.Email;
import com.company.emailsenderapiwithevent.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmailController
{

    private final EmailSenderService emailSenderService;

    @PostMapping("/email")
    public ResponseEntity<ResponseDTO> sendEmail (
            @RequestBody EmailDTO emailDTO
                                                 )
    {
        Email email = new Email();
        email.setTo(emailDTO.getTo());
        email.setTopic(emailDTO.getTopic());
        email.setMessage(emailDTO.getMessage());

        emailSenderService.sendEmail(email);
        return ResponseEntity.ok(ResponseDTO.of(emailDTO, "Successfully send"));
    }

    @GetMapping("/lastEmails")
    public ResponseEntity<ResponseDTO> getLastEmails ()
    {
        List<Email> emails = emailSenderService.getLastEmails();
        List<EmailDTO> emailDTOS = new ArrayList<>();
        emails.forEach((email) -> emailDTOS.add(EmailDTO.of(email)));
        return ResponseEntity.ok(ResponseDTO.of(emailDTOS, "Successfully got!"));
    }
}

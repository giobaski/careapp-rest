package com.knits.kncare.service;

import com.knits.kncare.email.EmailSender;
import com.knits.kncare.model.Email;
import com.knits.kncare.repository.EmailRepository;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class SendEmailService{

    private final EmailRepository emailRepository;
    private final EmailSender emailSender;

    public SendEmailService(EmailRepository emailRepository, EmailSender emailSender) {
        this.emailRepository = emailRepository;
        this.emailSender = emailSender;
    }

    public void sendDraft(Long draftIds) {

        Email draft = emailRepository.findById(draftIds)
                .orElseThrow(() -> new RuntimeException("No such draft"));

        try {
            emailSender.sendDraft(draft);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}

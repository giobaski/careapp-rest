package com.knits.kncare.controller;

import com.knits.kncare.dto.EmailSentDto;
import com.knits.kncare.service.SendEmailService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/v1/sendEmails")
@RestController
public class SendEmailController {

    private final SendEmailService service;

    public SendEmailController(SendEmailService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public ResponseEntity<EmailSentDto> getEmailSentById (@PathVariable("id") Long id) {
        Optional<EmailSentDto> emailSentDto = service.getById(id);
        return emailSentDto.map(email -> new ResponseEntity<>(email, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public Page<EmailSentDto> searchEmailSent(EmailSentDto dto) {
        return service.search(dto);
    }

    @PostMapping("/drafts/{id}")
    public ResponseEntity<HttpStatus> sendEmail(@PathVariable("id") Long draftId) {
        service.sendDraft(draftId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

package com.knits.kncare.controller;

import com.knits.kncare.service.SendEmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RequestMapping("/api/v1/sendEmails")
@RestController
public class SendEmailController {

    private final SendEmailService service;

    public SendEmailController(SendEmailService service) {
        this.service = service;
    }

    @PostMapping("/drafts/{id}")
    public ResponseEntity<HttpStatus> sendEmail(@PathVariable("id") Long draft) {
        service.sendDraft(draft);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

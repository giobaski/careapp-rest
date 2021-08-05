package com.knits.kncare.controller;

import com.knits.kncare.dto.EmailDto;
import com.knits.kncare.model.Email;
import com.knits.kncare.service.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/v1/emails")
@RestController
public class EmailController {
    
    private final EmailService service;

    public EmailController(EmailService service) {
        this.service = service;
    }

    @Operation(summary="find an Email by id")
    @GetMapping("{id}")
    public ResponseEntity<Email> getEmailById(@PathVariable("id") long id) {
        Optional<Email> EmailData = service.getById(id);
        return EmailData.map(Email -> new ResponseEntity<>(Email, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary="create an Email")
    @PostMapping
    public ResponseEntity<Email> createEmail(@RequestBody EmailDto emailDto) {
        try {
            return new ResponseEntity<>(service.addNew(emailDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary="update an Email")
    @PutMapping("{id}")
    public ResponseEntity<Email> updateUser(@PathVariable("id") long id, @RequestBody EmailDto Email) {
//        Optional<Email> EmailData = service.getbyId(id);
//
//        if (EmailData.isPresent()) {
//            return new ResponseEntity<>(service.Add(Email), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        return null;
    }

    @Operation(summary="delete an Email by id")
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmail(@PathVariable("id") long id) {
//        try {
//            service.delete(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
        return null;
    }

    @Operation(summary="find Emails by one of its model fields")
    @GetMapping
//    @JsonView(Views.Public.class)
    public Page<Email> searchEmails(EmailDto EmailDto) {
        return service.search(EmailDto);
    }
}

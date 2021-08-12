package com.knits.kncare.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.knits.kncare.dto.EmailDto;
import com.knits.kncare.dto.Views;
import com.knits.kncare.service.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    @JsonView(Views.EmailDetails.class)
    public ResponseEntity<EmailDto> getEmailById(@PathVariable("id") long id) {
        Optional<EmailDto> EmailData = service.getById(id);
        return EmailData.map(Email -> new ResponseEntity<>(Email, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary="create an Email")
    @PostMapping
    @JsonView(Views.EmailDetails.class)
    public ResponseEntity<EmailDto> createEmail(@RequestBody EmailDto emailDto) {
        try {
            return new ResponseEntity<>(service.addNew(emailDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary="update an Email")
    @PutMapping("{id}")
    @JsonView(Views.EmailDetails.class)
    public ResponseEntity<EmailDto> updateEmail(@PathVariable("id") long id, @RequestBody EmailDto email) {
        return new ResponseEntity<>(service.update(id, email), HttpStatus.OK);
    }

    @Operation(summary="delete an Email by id")
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmail(@PathVariable("id") long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary="find Emails by one of its model fields")
    @GetMapping
    @JsonView(Views.EmailDetails.class)
    public ResponseEntity<Page<EmailDto>> searchEmails(EmailDto EmailDto) {

        Page<EmailDto> search = service.search(EmailDto);
        System.out.println(search);
        return new ResponseEntity<>(search, HttpStatus.OK);
    }

    @PostMapping("/{id}/recipients/{memberId}")
    public ResponseEntity<HttpStatus> addRecipients(@PathVariable long id, @PathVariable List<Long> memberId) {
        try {
            service.addRecipients(id, memberId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}/recipients/{memberId}")
    public ResponseEntity<HttpStatus> deleteRecipients(@PathVariable long id, @PathVariable List<Long> memberId) {
        try {
            service.deleteRecipients(id, memberId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{id}/groups/{groupIds}")
    public ResponseEntity<HttpStatus> addGroups(@PathVariable long id, @PathVariable List<Long> groupIds) {
        try {
            service.addGroups(id, groupIds);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}/groups/{groupIds}")
    public ResponseEntity<HttpStatus> deleteGroups(@PathVariable long id, @PathVariable List<Long> groupIds) {
        try {
            service.deleteGroups(id, groupIds);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

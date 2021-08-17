package com.knits.kncare.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.knits.kncare.dto.MemberDto;
import com.knits.kncare.dto.Views;
import com.knits.kncare.dto.search.MemberSearchDto;
import com.knits.kncare.model.Member;
import com.knits.kncare.repository.EmployeeRepository;
import com.knits.kncare.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/v1/members")
@RestController
@JsonView(Views.Common.class)
public class MemberController {
    private final MemberService service;
    private final EmployeeRepository repository;


    @Autowired
    public MemberController(MemberService service, EmployeeRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @Operation(summary = "find a care member by id")
    @GetMapping("{id}")
    @JsonView(Views.MemberDetails.class)
    public ResponseEntity<Member> getMemberById(@PathVariable("id") long id) {
        Optional<Member> memberData = service.getById(id);
        return memberData.map(member -> new ResponseEntity<>(member, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "create a care member")
    @PostMapping
    @JsonView(Views.MemberDetails.class)
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        try {
            return new ResponseEntity<>(service.add(member), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "update a care member")
    @PutMapping("{id}")
    @JsonView(Views.MemberDetails.class)
    public ResponseEntity<Member> updateMember(@PathVariable("id") long id, @RequestBody Member member) {
        Optional<Member> memberData = service.getById(id);

        if (memberData.isPresent()) {
            return new ResponseEntity<>(service.add(member), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "delete a care member by id")
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteMember(@PathVariable("id") long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "delete all care members")
    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllMembers() {
        try {
            service.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Operation(summary = "find care members by one of its model fields")
    @GetMapping
    @JsonView(Views.Common.class)
    public ResponseEntity<Page<MemberDto>> searchMembers(MemberSearchDto memberSearchDto) {
        try {
            return new ResponseEntity<>(service.search(memberSearchDto),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

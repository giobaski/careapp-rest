package com.knits.kncare.controller;

import com.knits.kncare.model.Member;
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
public class MemberController {
    private final MemberService service;

    @Autowired
    public MemberController(MemberService service) {
        this.service = service;
    }


    @Operation(summary="find a care member by id")
    @GetMapping("{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable("id") long id) {
        Optional<Member> memberData = service.getbyId(id);
        return memberData.map(member -> new ResponseEntity<>(member, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary="create a care member")
    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        try {
            return new ResponseEntity<>(service.Add(member), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary="update a care member")
    @PutMapping("{id}")
    public ResponseEntity<Member> updateUser(@PathVariable("id") long id, @RequestBody Member member) {
        Optional<Member> memberData = service.getbyId(id);

        if (memberData.isPresent()) {
            return new ResponseEntity<>(service.Add(member), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary="delete a care member by id")
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteMember(@PathVariable("id") long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary="delete all care members")
    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllMembers() {
        try {
            service.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Operation(summary="find care members by one of its model fields")
    @GetMapping
//    @JsonView(Views.Public.class)
    public List<Member> searchMembers(Member member) {
        return service.searchMember(member);
    }
}

package com.knits.kncare.controller;

import com.knits.kncare.model.Member;
import com.knits.kncare.service.MemberService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class MemberController {
    private final MemberService service;

    @Autowired
    public MemberController(MemberService service) {
        this.service = service;
    }


    @ApiOperation(value="find a care member by id", notes="provide an id", response = Member.class)
    @GetMapping("/members/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable("id") long id) {
        Optional<Member> memberData = service.getbyId(id);
        return memberData.map(member -> new ResponseEntity<>(member, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @ApiOperation(value="create a care member", notes="provide a valid care member", response = Member.class)
    @PostMapping("/members")
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        try {
            return new ResponseEntity<>(service.Add(member), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value="update a care member", notes="provide a valid care member", response = Member.class)
    @PutMapping("/members/{id}")
    public ResponseEntity<Member> updateUser(@PathVariable("id") long id, @RequestBody Member member) {
        Optional<Member> memberData = service.getbyId(id);

        if (memberData.isPresent()) {
            return new ResponseEntity<>(service.Add(member), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value="delete a care member by id", notes="provide an id", response = Member.class)
    @DeleteMapping("/members/{id}")
    public ResponseEntity<HttpStatus> deleteMember(@PathVariable("id") long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value="delete all care members", notes="", response = Member.class)
    @DeleteMapping("/members")
    public ResponseEntity<HttpStatus> deleteAllMembers() {
        try {
            service.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @ApiOperation(value="find care members by one of its model fields", notes="provide parameters", response = Member.class)
    @GetMapping("/members")
//    @JsonView(Views.Public.class)
    public List<Member> searchMembers(Member member) {
        return service.searchMember(member);
    }
}

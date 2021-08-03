package com.example.KnCare.controller;

import com.example.KnCare.dto.MemberDto;
import com.example.KnCare.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    @JsonView(Views.Public.class)
//    @GetMapping("/members")
//    public ResponseEntity<List<Member>> getAllMembers() {
//        try {
//            List<Member> members = new ArrayList<>();
//            members.addAll(service.getAll());
//            return new ResponseEntity<>(members, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
    @GetMapping("/members/{id}")
    public ResponseEntity<MemberDto> getMemberById(@PathVariable("id") long id) {
        Optional<MemberDto> memberData = service.getbyId(id);
        return memberData.map(member -> new ResponseEntity<>(member, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/members")
    public ResponseEntity<MemberDto> createMember(@RequestBody MemberDto memberDto) {
        try {
            return new ResponseEntity<>(service.Add(memberDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/members/{id}")
    public ResponseEntity<MemberDto> updateUser(@PathVariable("id") long id, @RequestBody MemberDto memberDto) {
        Optional<MemberDto> memberData = service.getbyId(id);

        if (memberData.isPresent()) {
            return new ResponseEntity<>(service.Add(memberDto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<HttpStatus> deleteMember(@PathVariable("id") long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/members")
    public ResponseEntity<HttpStatus> deleteAllMembers() {
        try {
            service.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/members")
//    @JsonView(Views.Public.class)
    public Page<MemberDto> searchMembers(MemberDto memberDto) {
        return service.searchMember(memberDto);
    }

}

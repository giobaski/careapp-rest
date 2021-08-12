package com.knits.kncare.controller;

import com.knits.kncare.dto.GroupDto;
import com.knits.kncare.service.GroupService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/groups")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }


    @Operation(summary = "create a new group")
    @PostMapping
    public ResponseEntity<GroupDto> createGroup(@RequestBody GroupDto groupDto) {
        try {
            return new ResponseEntity<>(groupService.create(groupDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "update the existing group with new members")
    @PutMapping("{id}")
    public ResponseEntity<GroupDto> updateGroup(@PathVariable("id") long id, @RequestBody GroupDto groupDto) {
            return new ResponseEntity<>(groupService.update(id, groupDto),HttpStatus.OK);
    }

//    @Operation(summary="find a Group by id")
//    @GetMapping("{id}")
//    public ResponseEntity<GroupDto> getEmailById(@PathVariable("id") long id) {
//    }

    @Operation(summary = "search groups by the name???")
    @GetMapping
    public Page<GroupDto> searchGroups (GroupDto groupDto){
        return groupService.search(groupDto);

    }


}
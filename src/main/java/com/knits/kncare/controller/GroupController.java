package com.knits.kncare.controller;

import com.knits.kncare.dto.GroupDto;
import com.knits.kncare.service.GroupService;
import io.swagger.v3.oas.annotations.Operation;
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


//good
//    @Operation(summary="update the group")
//    @PutMapping("{id}")
//    public ResponseEntity<GroupDto> updateGroup(@PathVariable("id") long id, @RequestBody GroupDto groupDto) {
//        Optional<GroupDto> existingGroupDto = groupService.getbyId(id);  //here we are loosing membersIds from dto
//
//        if (existingGroupDto.isPresent()) {
//            GroupDto groupDto_ = existingGroupDto.get();
//            groupDto_.setMemberIds(groupDto.getMemberIds());
//            return new ResponseEntity<>(groupService.create(groupDto_), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @PutMapping("{id}")
    public ResponseEntity<GroupDto> updateGroup(@PathVariable("id") long id, @RequestBody GroupDto groupDto) {
            return new ResponseEntity<>(groupService.update(id, groupDto),HttpStatus.OK);
}


}

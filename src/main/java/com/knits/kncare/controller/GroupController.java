package com.knits.kncare.controller;

import com.knits.kncare.dto.GroupDto;
import com.knits.kncare.service.GroupService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/groups")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }



    @Operation(summary="create a new group")
    @PostMapping
    public ResponseEntity<GroupDto> createGroup (@RequestBody GroupDto groupDto){

        System.out.println("GroupDto From Controller:" + groupDto);
        try{
            return new ResponseEntity<>(groupService.create(groupDto), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//
//    @Operation(summary="edit the group")
//    @PutMapping("{id}")
//    public ResponseEntity<GroupDto> updateGroup(@PathVariable("id") long id, @RequestBody GroupDto groupDto){
//
//    }

}

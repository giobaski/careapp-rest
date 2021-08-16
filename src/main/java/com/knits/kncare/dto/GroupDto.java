package com.knits.kncare.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.knits.kncare.model.GroupMembership;
import com.knits.kncare.model.Member;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Transient;
import java.util.*;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupDto {

    @JsonView(Views.Common.class)
    private Long id;

    @JsonView(Views.Common.class)
    private String name;

    @JsonView(Views.Common.class)
    private String description;

    @JsonView(Views.Common.class)
    private Set<Long> memberIds= new HashSet<>();

    @JsonView(Views.GroupMembers.class)
    private Set<MemberDto> members= new HashSet<>();

    @JsonView(Views.GroupMembership.class)
    private Set<GroupMembershipDto> groupMemberships = new HashSet<>();

    public GroupDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public GroupDto(String name, String description) {
        this.name = name;
        this.description = description;
    }


}

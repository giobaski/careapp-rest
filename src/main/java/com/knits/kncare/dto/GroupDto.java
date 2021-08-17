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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupDto {

    @JsonView(Views.Common.class)
    private Long id;

    @JsonView(Views.Common.class)
    @NotNull(message = "Group Name Should Not Be Null")
    @NotBlank(message = "Group Name Should Not Be Empty and must contain at least one non-whitespace character")
    @Size(min = 1, max = 100, message = "")
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

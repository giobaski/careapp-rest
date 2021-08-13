package com.knits.kncare.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupDto extends AbstractSearchableDto{

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


//    @JsonBackReference
//    private Set<GroupMembership> groupMemberships = new HashSet<>();



}

package com.knits.kncare.dto;

import com.knits.kncare.model.GroupMembership;
import com.knits.kncare.model.Member;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupDto extends AbstractSearchableDto{

    private Long id;

    private String name;

    private String description;

    //testing
    private Set<Long> memberIds;

    private Set<GroupMembership> groupMemberships = new HashSet<>();



}

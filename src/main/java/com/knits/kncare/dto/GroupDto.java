package com.knits.kncare.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.knits.kncare.model.Group;
import com.knits.kncare.model.GroupMembership;
import com.knits.kncare.model.Member;
import lombok.*;

import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupDto extends AbstractSearchableDto<Group>{

    private Long id;

    private String name;

    private String description;

    @Transient
    private Set<Long> memberIds;

    @JsonBackReference
    private Set<GroupMembership> groupMemberships = new HashSet<>();



}

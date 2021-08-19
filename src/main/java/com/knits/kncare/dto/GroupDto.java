package com.knits.kncare.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupDto {

    @JsonView(Views.Common.class)
    private Long id;

    @JsonView(Views.Common.class)
    @NotNull(message = "Group name must not be Null")
    @NotBlank(message = "Group name must not be Null and must contain at least one non-whitespace character")
    @Size(min = 1, max = 100, message = "Group name size must be in 1-100 range")
    private String name;

    @JsonView(Views.Common.class)
    private String description;

    @JsonView(Views.Common.class)
    private Set<MemberDto> members = new HashSet<>();

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

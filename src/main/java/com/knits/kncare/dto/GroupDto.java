package com.knits.kncare.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;


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
    private Set<Long> memberIds;

    @JsonView(Views.GroupMembers.class)
    private Set<MemberDto> members;

    @JsonView(Views.GroupMembership.class)
    private Set<GroupMembershipDto> groupMemberships;

    public GroupDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public GroupDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupDto groupDto = (GroupDto) o;
        return id.equals(groupDto.id) && Objects.equals(name, groupDto.name) && Objects.equals(description, groupDto.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}

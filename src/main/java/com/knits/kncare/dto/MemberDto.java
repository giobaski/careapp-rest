package com.knits.kncare.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import java.util.Objects;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonView(Views.Common.class)
public class MemberDto {

    private Long id;
    private String onBoardDate;
    private String offBoardDate;
    private EmployeeDto employee;

    @JsonView(Views.MemberDetails.class)
    private Set<GroupMembershipDto> groupMemberships;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberDto memberDto = (MemberDto) o;
        return id.equals(memberDto.id) && Objects.equals(employee, memberDto.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employee);
    }
}

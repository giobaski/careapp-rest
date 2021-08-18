package com.knits.kncare.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

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


}

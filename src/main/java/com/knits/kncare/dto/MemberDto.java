package com.knits.kncare.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.knits.kncare.dto.search.AbstractSearchableDto;
import com.knits.kncare.model.GroupMembership;
import com.knits.kncare.model.Member;
import com.knits.kncare.model.Role;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonView(Views.Common.class)
public class MemberDto extends AbstractSearchableDto<Member> {

    @JsonView(Views.Common.class)
    private Long id;

    @JsonView(Views.Common.class)
    private LocalDate onBoardDate;

    @JsonView(Views.Common.class)
    private LocalDate offBoardDate;

    @JsonView(Views.MemberDetails.class)
    private EmployeeDto employee;

    @JsonView(Views.Common.class)
    private Role role;

    @JsonView(Views.MemberDetails.class)
    private Set<GroupMembership> groupMemberships;

}

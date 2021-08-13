package com.knits.kncare.dto;

import com.knits.kncare.model.GroupMembership;
import com.knits.kncare.model.Member;
import com.knits.kncare.model.Role;
import lombok.*;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto extends AbstractSearchableDto {

    private Long id;
    private String onBoardDate;
    private String offBoardDate;

//    //References:
    private EmployeeDtoTest employee;

    private Role role;

    private Set<GroupMembership> groupMemberships;


}

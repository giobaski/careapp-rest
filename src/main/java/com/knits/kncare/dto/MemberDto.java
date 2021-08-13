package com.knits.kncare.dto;

import lombok.*;

import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {

    private Long id;
    private String onBoardDate;
    private String offBoardDate;


    private Set<GroupMembershipDto> groupMemberships;


}

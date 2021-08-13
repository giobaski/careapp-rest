package com.knits.kncare.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GroupMembershipDto {

    private GroupDto group;
    private MemberDto member;
    private String createdAt;
    private String updatedAt;

}

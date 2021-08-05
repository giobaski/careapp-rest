package com.knits.kncare.dto;

import com.knits.kncare.model.Member;
import com.knits.kncare.model.ems.Employee;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto extends AbstractSearchableDto<Member> {

    private Long id;
    private String onBoardDate;
    private String offBoardDate;


    Employee employee;
/*
    Set<MemberTraining> memberTrainings;

    Set<GroupMembership> groupMemberships;

    Set<MemberTrainingPath> memberTrainingPaths;

    Set<Practice> practices;

    Set<MemberRoles> memberRoles;

    Set<Email> emails;

    Set<EmailTemplate> emailTemplates;

    Set<Notification> notifications;
    */

}

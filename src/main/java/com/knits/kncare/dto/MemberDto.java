package com.example.KnCare.dto;

import com.example.KnCare.model.*;
import lombok.*;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto extends DtoBase{

    private Long id;
    private String onBoardDate;
    private String offBoardDate;


    Employee employee;

    Set<MemberTraining> memberTrainings;

    Set<GroupMembership> groupMemberships;

    Set<MemberTrainingPath> memberTrainingPaths;

    Set<Practice> practices;

    Set<MemberRoles> memberRoles;

    Set<Email> emails;

    Set<EmailTemplate> emailTemplates;

    Set<Notification> notifications;
}

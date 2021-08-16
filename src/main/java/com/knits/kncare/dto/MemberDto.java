package com.knits.kncare.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.knits.kncare.model.*;
import com.knits.kncare.model.ems.Employee;
import com.knits.kncare.model.history.RoleHistoryRecord;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@EqualsAndHashCode()
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {

    @JsonView(Views.EntityData.class)
    private Long id;

    @JsonView(Views.EntityData.class)
    private LocalDateTime onBoardDate;

    @JsonView(Views.EntityData.class)
    private LocalDateTime offBoardDate;

    @JsonView(Views.EntityData.class)
    private Employee employee;

    @JsonView(Views.EntityData.class)
    private Role role;

    @JsonView(Views.MemberDetails.class)
    private Set<Practice> practices;

    @JsonView(Views.MemberDetails.class)
    private Set<Email> emails;

    @JsonView(Views.MemberDetails.class)
    private Set<EmailTemplate> emailTemplates;

    @JsonView(Views.MemberDetails.class)
    private Set<Notification> notifications;

    @JsonView(Views.MemberDetails.class)
    private Set<GroupMembership> groupMemberships;

    @JsonView(Views.MemberDetails.class)
    private Set<LearningSubscription> memberTrainingPaths;

    @JsonView(Views.MemberDetails.class)
    private Set<ScheduledTraining> memberTrainings;

    @JsonView(Views.MemberDetails.class)
    private Set<RoleHistoryRecord> businessUnitHistoryRecords;


}

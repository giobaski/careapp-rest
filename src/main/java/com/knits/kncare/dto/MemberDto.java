package com.knits.kncare.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.knits.kncare.model.*;
import com.knits.kncare.model.ems.Employee;
import com.knits.kncare.model.history.RoleHistoryRecord;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto extends AbstractSearchableDto<Member> {

    @JsonView(Views.Public.class)
    private Long id;

    @JsonView(Views.Public.class)
    private LocalDateTime onBoardDate;

    @JsonView(Views.Public.class)
    private LocalDateTime offBoardDate;

    @JsonView(Views.Public.class)
    private Employee employee;

    @JsonView(Views.Public.class)
    private Role role;

    @JsonView(Views.Internal.class)
    private Set<Practice> practices;

    @JsonView(Views.Internal.class)
    private Set<EmailDto> emails;

    @JsonView(Views.Internal.class)
    private Set<EmailTemplate> emailTemplates;

    @JsonView(Views.Internal.class)
    private Set<Notification> notifications;

    @JsonView(Views.Internal.class)
    private Set<GroupMembership> groupMemberships;

    @JsonView(Views.Internal.class)
    private Set<LearningSubscription> memberTrainingPaths;

    @JsonView(Views.Internal.class)
    private Set<ScheduledTraining> memberTrainings;

    @JsonView(Views.Internal.class)
    private Set<RoleHistoryRecord> businessUnitHistoryRecords;


}

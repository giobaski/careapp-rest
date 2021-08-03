package com.knits.kncare.dto;

import com.knits.kncare.dto.DtoBase;
import com.knits.kncare.model.*;
import com.knits.kncare.model.ems.Employee;
import com.knits.kncare.model.history.RoleHistoryRecord;
import lombok.*;

import javax.persistence.OneToMany;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto extends DtoBase {

    private Long id;
    private String onBoardDate;
    private String offBoardDate;


    Employee employee;

    private Set<Practice> practices;

    private Set<Email> emails;

    private Set<EmailTemplate> emailTemplates;

    private Set<Notification> notifications;

    private Set<GroupMembership> groupMemberships;

    private Set<LearningSubscription> memberTrainingPaths;

    private Set<ScheduledTraining> memberTrainings;

    private Set<RoleHistoryRecord> businessUnitHistoryRecords;
}

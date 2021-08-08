package com.knits.kncare.dto;

import com.knits.kncare.model.*;
import com.knits.kncare.model.ems.Employee;
import com.knits.kncare.model.history.RoleHistoryRecord;
import com.knits.kncare.utils.Specifications;
import lombok.*;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {

    private Long id;

    private LocalDateTime onBoardDate;

    private LocalDateTime offBoardDate;

    private Employee employee;

    private Role role;

    private Set<Practice> practices;

    private Set<Email> emails;

    private Set<EmailTemplate> emailTemplates;

    private Set<Notification> notifications;

    private Set<GroupMembership> groupMemberships;

    private Set<LearningSubscription> memberTrainingPaths;

    private Set<ScheduledTraining> memberTrainings;

    private Set<RoleHistoryRecord> businessUnitHistoryRecords;


}

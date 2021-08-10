package com.knits.kncare.model;

import com.knits.kncare.model.ems.Employee;
import com.knits.kncare.model.history.RoleHistoryRecord;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

//@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "\"member\"") //some Db have member as sql function
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;            //TODO: add index

    @Column(name = "onboard_date", nullable = false)
    private LocalDateTime onBoardDate;

    @Column(name = "offboard_date", nullable = false)
    private LocalDateTime offBoardDate;

    @OneToOne(optional = false)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "createdBy")
    private Set<Practice> practices;

    @OneToMany(mappedBy = "createdBy")
    private Set<Email> emails;

    @OneToMany(mappedBy = "createdBy")
    private Set<EmailTemplate> emailTemplates;

    @OneToMany(mappedBy = "createdBy")
    private Set<Notification> notifications;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private Set<GroupMembership> groupMemberships;

    @OneToMany(mappedBy = "createdBy")
    private Set<LearningSubscription> memberTrainingPaths;

    @OneToMany(mappedBy = "createdBy")
    private Set<ScheduledTraining> memberTrainings;

    @OneToMany(mappedBy = "member")
    private Set<RoleHistoryRecord> businessUnitHistoryRecords;
}

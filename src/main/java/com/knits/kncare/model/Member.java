package com.knits.kncare.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.knits.kncare.model.ems.Employee;
import com.knits.kncare.model.history.RoleHistoryRecord;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

//@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "\"member\"") //some Db have member as sql function
@JsonIgnoreProperties
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private Set<Email> emails;

    @OneToMany(mappedBy = "createdBy")
    private Set<EmailTemplate> emailTemplates;

    @OneToMany(mappedBy = "createdBy")
    private Set<Notification> notifications;

    @OneToMany(mappedBy = "member")
    private Set<GroupMembership> groupMemberships;

    @OneToMany(mappedBy = "createdBy")
    private Set<LearningSubscription> memberTrainingPaths;

    @OneToMany(mappedBy = "createdBy")
    private Set<ScheduledTraining> memberTrainings;

    @OneToMany(mappedBy = "member")
    private Set<RoleHistoryRecord> businessUnitHistoryRecords;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;
        Member member = (Member) o;
        return Objects.equals(getId(), member.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

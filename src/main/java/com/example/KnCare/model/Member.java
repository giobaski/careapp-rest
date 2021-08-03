package com.example.KnCare.model;

import com.example.KnCare.model.base.ModelBase;
import com.example.KnCare.model.base.Views;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import com.example.KnCare.utils.Specifications;
import com.fasterxml.jackson.annotation.JsonView;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name= "members")
public class Member extends ModelBase<Member>{

    @Id
    @JsonView(Views.Internal.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;            //TODO: add index

    @JsonView(Views.Public.class)
    @Column(name = "on_board_date", nullable = false)
    private String onBoardDate; //TODO: Using String for date type, just for testing
    //TODO: Using String for date type, just for testing


    @Column(name = "off_board_date", nullable = false)
    @JsonView(Views.Public.class)
    private String offBoardDate;



    @OneToOne(cascade= CascadeType.ALL, fetch=FetchType.EAGER, optional = false)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    Employee employee;

    @OneToMany(mappedBy = "member")
    Set<MemberTraining> memberTrainings;

    @OneToMany(mappedBy = "member")
    Set<GroupMembership> groupMemberships;

    @OneToMany(mappedBy = "member")
    Set<MemberTrainingPath> memberTrainingPaths;

    @OneToMany(mappedBy = "member")
    Set<Practice> practices;

    @OneToMany(mappedBy = "member")
    Set<MemberRoles> memberRoles;

    @OneToMany(mappedBy = "sender")
    Set<Email> emails;

    @OneToMany(mappedBy = "created_by")
    Set<EmailTemplate> emailTemplates;

    @OneToMany(mappedBy = "member")
    Set<Notification> notifications;




    @Override
    public Specification<Member> getSpecification() {
        Specification<Member> spec = super.getSpecification();
        if (Strings.isNotBlank(onBoardDate)){
            spec = spec.and(Specifications.specLike("onBoardDate", "%" + onBoardDate + "%")) ;
        }
        if (Strings.isNotBlank(offBoardDate)){
            spec = spec.and(Specifications.specLike("offBoardDate", "%" + offBoardDate + "%")) ;
        }
        return spec;
    }

}

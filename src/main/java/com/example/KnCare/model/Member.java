package com.example.KnCare.model;

import com.example.KnCare.model.base.ModelBase;
import com.example.KnCare.model.base.Views;
import com.example.KnCare.model.bestPractice.BestPractice;
import com.example.KnCare.model.training.Training;
import com.example.KnCare.model.training.TrainingPath;
import lombok.*;

import com.example.KnCare.utils.Specifications;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;            //TODO: add index

    @JsonView(Views.Public.class)
    @Column(name = "on_board_date", nullable = false)
    private String onBoardDate; //TODO: Using String for date type, just for testing
    //TODO: Using String for date type, just for testing


    @Column(name = "off_board_date", nullable = false)
    @JsonView(Views.Public.class)
    private String offBoardDate;

    @OneToOne(cascade= CascadeType.ALL, fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    Employee employee;

    @OneToMany(mappedBy = "member")
    Set<MemberTraining> memberTrainings;

    @OneToMany(mappedBy = "member")
    Set<MemberGroups> memberGroups;

    @OneToMany(mappedBy = "member")
    Set<MemberTrainingLists> memberTrainingLists;

    @OneToMany(mappedBy = "member")
    Set<Practice> practices;

    @Override
    public Specification<Member> getSpecification() {
        Specification<Member> spec = super.getSpecification();
        if (Strings.isNotBlank(onBoardDate)){
            spec.and(Specifications.specLike("onBoardDate", onBoardDate)) ;
        }
        if (Strings.isNotBlank(offBoardDate)){
            spec.and(Specifications.specLike("offBoardDate", offBoardDate)) ;
        }
        return spec;
    }

}

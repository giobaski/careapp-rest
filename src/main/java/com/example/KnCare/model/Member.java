package com.example.KnCare.model;

import com.example.KnCare.model.base.ModelBase;
import com.example.KnCare.model.base.Views;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(Views.Internal.class)
    private Long id;

    //TODO: Using String for date type, just for testing
    @JsonView(Views.Public.class)
    private String onBoardDate;

    @JsonView(Views.Public.class)
    private String offBoardDate;

    @OneToOne()
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

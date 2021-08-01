package com.example.KnCare.model;

import com.example.KnCare.model.base.ModelBase;
import com.example.KnCare.utils.Specifications;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "members")
public class Member{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //TODO: Using String for date type, just for testing
    private String onBoardDate;

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

//    @Override
//    public Specification<Member> getSpecification() {
//        if (Strings.isNotBlank(onBoardDate)){
//            return Specifications.specLike("onBoardDate", onBoardDate);
//        }
//        if (Strings.isNotBlank(offBoardDate)){
//            return Specifications.specLike("offBoardDate", offBoardDate);
//        }
//        return null;
//    }

}

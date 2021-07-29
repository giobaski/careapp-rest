package com.example.KnCare.model;

import com.example.KnCare.utils.Specifications;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.*;

@Entity
@Table(name= "care_members")
public class Member extends ModelBase<Member> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //TODO: Using String for date type, just for testing
    private String onBoardDate;

    private String offBoardDate;

    @OneToOne()
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    Employee employee;

    @Override
    public Specification<Member> getSpecification() {
        if (Strings.isNotBlank(onBoardDate)){
            return Specifications.specLike("onBoardDate", onBoardDate);
        }
        if (Strings.isNotBlank(offBoardDate)){
            return Specifications.specLike("offBoardDate", offBoardDate);
        }
        return null;
    }

}

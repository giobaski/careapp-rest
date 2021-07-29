package com.example.KnCare.model;

import com.example.KnCare.utils.Specifications;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee extends ModelBase<Employee>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String intName;

    private boolean careMember;

    @Override
    public Specification<Employee> getSpecification() {
        if (Strings.isNotBlank(intName)){
            return Specifications.specLike("intName", intName);
        }
        return null;
    }
}

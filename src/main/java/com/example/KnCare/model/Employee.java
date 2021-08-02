package com.example.KnCare.model;

import com.example.KnCare.model.base.ModelBase;
import com.example.KnCare.utils.Specifications;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "employees")
public class Employee extends ModelBase<Employee> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String intName;

    private boolean careMember;

    @Override
    @JsonIgnore
    public Specification<Employee> getSpecification() {
        if (Strings.isNotBlank(intName)){
            return Specifications.specLike("intName", intName);
        }
        return null;
    }
}

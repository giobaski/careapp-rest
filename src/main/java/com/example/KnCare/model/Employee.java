package com.example.KnCare.model;

import com.example.KnCare.model.base.ModelBase;
import com.example.KnCare.utils.Specifications;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "employees")
public class Employee extends ModelBase<Employee> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "international_name", length = 100, nullable = false)
    private String internationalName;

    @Column(name = "is_care_member")
    private boolean careMember;

    @Override
    @JsonIgnore
    public Specification<Employee> getSpecification() {
        if (Strings.isNotBlank(internationalName)){
            return Specifications.specLike("international_name", internationalName);
        }
        return null;
    }
}

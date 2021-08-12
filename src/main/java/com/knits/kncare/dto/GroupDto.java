package com.knits.kncare.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.knits.kncare.model.Group;
import com.knits.kncare.model.GroupMembership;
import com.knits.kncare.model.Member;
import com.knits.kncare.utils.Specifications;
import lombok.*;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.Transient;
import java.util.*;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupDto extends AbstractSearchableDto<Group>{

    private Long id;

    private String name;

    private String description;

//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Transient
    private Set<Long> memberIds;

    @JsonBackReference
    private Set<GroupMembership> groupMemberships = new HashSet<>();


    @Override
    public Specification<Group> getSpecification() {
        Specification<Group> spec = super.getSpecification();
        if (Strings.isNotBlank(name)) {
            spec = spec.and(Specifications.specLike("name", "%"+name+"%"));
        }

        return spec;
    }

}

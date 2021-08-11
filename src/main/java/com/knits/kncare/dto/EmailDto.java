package com.knits.kncare.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.knits.kncare.model.Email;
import com.knits.kncare.model.Group;
import com.knits.kncare.utils.Specifications;
import lombok.*;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailDto extends AbstractSearchableDto<Email> {

    @JsonView(Views.Public.class)
    private Long id;

    @JsonView(Views.Public.class)
    private String subject;

    @JsonView(Views.Public.class)
    private String content;

    @JsonView(Views.Internal.class)
    private MemberDto createdBy;

    @JsonView(Views.Public.class)
    private Set<MemberDto> recipients;

    @JsonView(Views.Public.class)
    private Set<Group> recipientGroups;

    @Override
    public Specification<Email> getSpecification() {
        Specification<Email> spec = super.getSpecification();
        if (Strings.isNotBlank(subject)) {
            spec = spec.and(Specifications.specLike("subject", "%"+subject+"%"));
        }
        if (Strings.isNotBlank(content)) {
            spec = spec.and(Specifications.specLike("content", "%"+content+"%"));
        }
        return spec;
    }


}

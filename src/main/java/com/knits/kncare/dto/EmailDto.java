package com.knits.kncare.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.knits.kncare.model.Email;
import com.knits.kncare.model.Group;
import com.knits.kncare.model.Member;
import com.knits.kncare.utils.Specifications;
import lombok.*;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

import java.util.Set;

//@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EmailDto extends AbstractSearchableDto<Email> {

    private Long id;

    private String subject;

    private String content;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Member createdBy;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<Member> recipients;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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

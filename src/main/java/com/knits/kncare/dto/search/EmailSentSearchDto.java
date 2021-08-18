package com.knits.kncare.dto.search;

import com.knits.kncare.model.EmailSent;
import com.knits.kncare.utils.Specifications;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

@EqualsAndHashCode(callSuper = true)
@Data
public class EmailSentSearchDto extends AbstractSearchableDto<EmailSent>{

    private String subject;

    @Override
    public Specification<EmailSent> getSpecification() {
        Specification<EmailSent> spec = super.getSpecification();
        if (Strings.isNotBlank(subject)) {
            spec = spec.and(Specifications.specLike("subject", "%"+subject+"%"));
        }
        return spec;
    }

}

package com.knits.kncare.dto.search;

import com.knits.kncare.model.EmailSent;
import org.springframework.data.jpa.domain.Specification;

public class EmailSentSearchDto extends AbstractSearchableDto<EmailSent>{

    @Override
    public Specification<EmailSent> getSpecification() {
        return super.getSpecification();
    }

}

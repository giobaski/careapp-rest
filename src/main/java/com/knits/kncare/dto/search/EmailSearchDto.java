package com.knits.kncare.dto.search;

import com.knits.kncare.model.Email;
import com.knits.kncare.utils.Specifications;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailSearchDto extends AbstractSearchableDto<Email>{

    private String subject;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    @Override
    public Specification<Email> getSpecification() {
        Specification<Email> spec = super.getSpecification();
        if (Strings.isNotBlank(subject)) {
            spec = spec.and(Specifications.specLike("subject", "%"+subject+"%"));
        }

        return spec;
    }
}

package com.knits.kncare.dto;

import com.knits.kncare.model.Member;
import com.knits.kncare.model.ems.*;
import com.knits.kncare.utils.Specifications;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

@Data
@NoArgsConstructor
public class MemberSearch {

    private String internationalName;

    private Long nationality;

    private Long businessUnit;

    private Long managementGroup;

    private Long costCenter;

}

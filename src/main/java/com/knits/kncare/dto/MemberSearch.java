package com.knits.kncare.dto;

import com.knits.kncare.model.Member;
import com.knits.kncare.model.ems.*;
import com.knits.kncare.utils.Specifications;
import lombok.Data;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

@Data
public class MemberSearch {
    private String firstName;

    private String lastName;

    private String internationalName;

    private String title;

    private String nationality;

    private String businessUnit;

    private String managementGroup;

    private String workingPosition;


}

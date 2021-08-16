package com.knits.kncare.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.knits.kncare.dto.search.AbstractSearchableDto;
import com.knits.kncare.model.Email;
import com.knits.kncare.model.Group;
import com.knits.kncare.utils.Specifications;
import lombok.*;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.util.Set;

//@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EmailDto  {

    private Long id;

    private String subject;

    private String content;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private MemberDto createdBy;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<MemberDto> recipients;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<Group> recipientGroups;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


}

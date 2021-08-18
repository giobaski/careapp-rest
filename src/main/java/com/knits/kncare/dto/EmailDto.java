package com.knits.kncare.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

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

    @JsonView(Views.Common.class)
    private Long id;

    @JsonView(Views.Common.class)
    private String subject;

    @JsonView(Views.Common.class)
    private String content;

    @JsonView(Views.Common.class)
    private MemberDto createdBy;

    @JsonView(Views.EmailDetails.class)
    private Set<MemberDto> recipients;

    @JsonView(Views.EmailDetails.class)
    private Set<GroupDto> recipientGroups;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


}

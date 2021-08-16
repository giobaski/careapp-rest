package com.knits.kncare.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.knits.kncare.model.Group;
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

    @JsonView(Views.EntityData.class)
    private Long id;

    @JsonView(Views.EntityData.class)
    private String subject;

    @JsonView(Views.EntityData.class)
    private String content;

    @JsonView(Views.EmailDetails.class)
    private MemberDto createdBy;

    @JsonView(Views.EmailDetails.class)
    private Set<MemberDto> recipients;

    @JsonView(Views.EmailDetails.class)
    private Set<Group> recipientGroups;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


}

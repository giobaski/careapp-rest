package com.knits.kncare.dto;

import com.knits.kncare.model.EmailSent;
import com.knits.kncare.model.Member;
import com.knits.kncare.model.status.Status.EmailSentStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailSentDto extends AbstractSearchableDto<EmailSent> {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;

    private String content;

    private Member recipient;

    private EmailSentStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}

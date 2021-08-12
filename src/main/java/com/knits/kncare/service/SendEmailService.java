package com.knits.kncare.service;

import com.knits.kncare.dto.EmailSentDto;
import com.knits.kncare.email.EmailSender;
import com.knits.kncare.mapper.MapperInterface;
import com.knits.kncare.model.Email;
import com.knits.kncare.model.EmailSent;
import com.knits.kncare.repository.EmailRepository;
import com.knits.kncare.repository.EmailSentRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Optional;

@Service
public class SendEmailService extends ServiceBase<EmailSent, EmailSentDto> {

    private final EmailSentRepository emailSentRepository;
    private final EmailRepository emailRepository;
    private final EmailSender emailSender;

    public SendEmailService(MapperInterface<EmailSent, EmailSentDto> mapper, EmailSentRepository emailSentRepository, EmailRepository emailRepository, EmailSender emailSender) {
        super(mapper);
        this.emailSentRepository = emailSentRepository;
        this.emailRepository = emailRepository;
        this.emailSender = emailSender;
    }

    public Optional<EmailSentDto> getById(Long id) {
        return toDtoOptional(emailSentRepository.findById(id));
    }

    public Page<EmailSentDto> search(EmailSentDto dto) {
        return toDtoPage(emailSentRepository.findAll(dto.getSpecification(), dto.getPageable()));
    }

    public void sendDraft(Long draftIds) {

        Email draft = emailRepository.findById(draftIds)
                .orElseThrow(() -> new RuntimeException("No such draft"));

        try {
            emailSender.sendDraft(draft);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    private boolean verifyDraft(Email draft) {
        return Strings.isNotBlank(draft.getContent()) &&
                Strings.isNotBlank(draft.getSubject()) &&
                (!draft.getRecipientGroups().isEmpty() || !draft.getRecipients().isEmpty()) &&
                draft.getCreatedBy() != null;
    }


}

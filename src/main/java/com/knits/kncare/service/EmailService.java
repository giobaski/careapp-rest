package com.knits.kncare.service;

import com.knits.kncare.dto.EmailDto;
import com.knits.kncare.mapper.MapperInterface;
import com.knits.kncare.model.Email;
import com.knits.kncare.repository.EmailRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmailService extends ServiceBase<Email, EmailDto>{

    private final EmailRepository emailRepository;

    public EmailService(MapperInterface<Email, EmailDto> mapper, EmailRepository emailRepository) {
        super(mapper);
        this.emailRepository = emailRepository;
    }

    public Optional<Email> getById(long id) {

        return emailRepository.findById(id);
    }

    public Email addNew(EmailDto emailDto) {
        Email email = toModel(emailDto);
        // TODO: 05/08/2021 Add more checks before adding new email.
        return emailRepository.save(email);
    }

    public Page<Email> search(EmailDto emailDto) {
        return emailRepository.findAll(emailDto.getSpecification(), emailDto.getPageable());
    }
}

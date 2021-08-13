package com.knits.kncare.service;

import com.knits.kncare.dto.EmailDto;
import com.knits.kncare.dto.search.EmailSearchDto;
import com.knits.kncare.mapper.MapperInterface;
import com.knits.kncare.model.Email;
import com.knits.kncare.model.Member;
import com.knits.kncare.repository.EmailRepository;
import com.knits.kncare.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailService extends ServiceBase<Email, EmailDto>{

    private final EmailRepository emailRepository;
    private final MemberRepository memberRepository;

    public EmailService(MapperInterface<Email, EmailDto> mapper, EmailRepository emailRepository, MemberRepository memberRepository) {
        super(mapper);
        this.emailRepository = emailRepository;
        this.memberRepository = memberRepository;
    }

    public Optional<Email> getById(long id) {

        return emailRepository.findById(id);
    }

    public EmailDto addNew(EmailDto emailDto) {
        Email email = toModel(emailDto);
        // TODO: 05/08/2021 Add more checks before adding new email.
        return toDto(emailRepository.save(email));
    }

    public Page<EmailDto> search(EmailSearchDto emailDto) {
        Page<Email> emails = emailRepository.findAll(emailDto.getSpecification(), emailDto.getPageable());
        return toDtoPage(emails);
    }

    public void delete(long id) {
        Optional<Email> optionalEmail = emailRepository.findById(id);
        Email email = optionalEmail.orElseThrow(() -> new RuntimeException("No such email!"));
        emailRepository.delete(email);
    }

    public EmailDto update(long id, EmailDto emailDto) {
        Email email = emailRepository.findById(id).orElseThrow(() -> new RuntimeException("No such email!"));
        email.setContent(emailDto.getContent());
        email.setSubject(emailDto.getSubject());
        emailRepository.save(email);
        return toDto(email);
    }

    public void addRecipient(long id, List<Long> memberIds) {
        Email email = emailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No such email!"));
        List<Member> members = memberRepository.findAllById(memberIds);

        members.forEach(email::addRecipient);
        emailRepository.save(email);
    }

    public void deleteRecipient(long id, List<Long> memberIds) {
        Email email = emailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No such email!"));
        List<Member> members = memberRepository.findAllById(memberIds);

        members.forEach(email::removeRecipient);
        emailRepository.save(email);
    }

}

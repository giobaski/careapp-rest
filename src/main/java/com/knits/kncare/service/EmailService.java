package com.knits.kncare.service;

import com.fasterxml.jackson.annotation.JsonView;
import com.knits.kncare.dto.EmailDto;
import com.knits.kncare.dto.Views;
import com.knits.kncare.dto.search.EmailSearchDto;
import com.knits.kncare.exception.EmailException;
import com.knits.kncare.mapper.MapperInterface;
import com.knits.kncare.model.Email;
import com.knits.kncare.model.Group;
import com.knits.kncare.model.Member;
import com.knits.kncare.repository.EmailRepository;
import com.knits.kncare.repository.GroupRepository;
import com.knits.kncare.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailService extends ServiceBase<Email, EmailDto>{

    private final EmailRepository emailRepository;
    private final MemberRepository memberRepository;
    private final GroupRepository groupRepository;

    public EmailService(MapperInterface<Email, EmailDto> mapper, EmailRepository emailRepository, MemberRepository memberRepository, GroupRepository groupRepository) {
        super(mapper);
        this.emailRepository = emailRepository;
        this.memberRepository = memberRepository;
        this.groupRepository = groupRepository;
    }

    public Optional<EmailDto> getById(long id) {
        return toDtoOptional(emailRepository.findById(id));
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

    public void delete(long id) throws EmailException {
        Optional<Email> optionalEmail = emailRepository.findById(id);
        Email email = optionalEmail.orElseThrow(() -> new EmailException("No such email!"));
        emailRepository.delete(email);
    }

    @JsonView(Views.Common.class)
    public EmailDto update(long id, EmailDto emailDto) throws EmailException {
        Email email = emailRepository.findById(id).orElseThrow(() -> new EmailException("No such email!"));
        email.setContent(emailDto.getContent());
        email.setSubject(emailDto.getSubject());
        email.setCreatedBy(memberRepository.findById(emailDto.getCreatedBy().getId()).orElseThrow(() -> new EmailException("No such member")));
        emailRepository.save(email);
        return toDto(email);
    }

    public void addRecipients(long id, List<Long> memberIds) throws EmailException {
        Email email = emailRepository.findById(id)
                .orElseThrow(() -> new EmailException("No such email!"));
        List<Member> members = memberRepository.findAllById(memberIds);

        members.forEach(email::addRecipient);
        emailRepository.save(email);
    }

    public void deleteRecipients(long id, List<Long> memberIds) throws EmailException {
        Email email = emailRepository.findById(id)
                .orElseThrow(() -> new EmailException("No such email!"));
        List<Member> members = memberRepository.findAllById(memberIds);

        members.forEach(email::removeRecipient);
        emailRepository.save(email);
    }

    public void addGroups(long id, List<Long> groupIds) throws EmailException {
        Email email = emailRepository.findById(id)
                .orElseThrow(() -> new EmailException("No such email!"));
        List<Group> groups = groupRepository.findAllById(groupIds);

        groups.forEach(email::addGroup);
        emailRepository.save(email);
    }

    public void deleteGroups(long id, List<Long> groupIds) throws EmailException {
        Email email = emailRepository.findById(id)
                .orElseThrow(() -> new EmailException("No such email!"));
        List<Group> groups = groupRepository.findAllById(groupIds);

        groups.forEach(email::removeGroup);
        emailRepository.save(email);
    }
}

package com.knits.kncare.mapper;

import com.knits.kncare.dto.EmailDto;
import com.knits.kncare.model.Email;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel="spring", uses = {MemberMapper.class, GroupMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface EmailMapper extends MapperInterface<Email, EmailDto> {

    @Override
    EmailDto toDto(Email email);

    @Override
    Email toModel(EmailDto emailDto);

    @Override
    List<EmailDto> toDtoList(List<Email> emailList);

    @Override
    Set<EmailDto> toDtoSet(Set<Email> emailSet);

    @Override
    List<Email> toModelList(List<EmailDto> emailDtoList);

    @Override
    Set<Email> toModelSet(Set<EmailDto> emailDtoSet);

}

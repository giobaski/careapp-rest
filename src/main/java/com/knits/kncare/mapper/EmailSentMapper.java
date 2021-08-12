package com.knits.kncare.mapper;

import com.knits.kncare.dto.EmailSentDto;
import com.knits.kncare.model.EmailSent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel="spring")
public interface EmailSentMapper extends MapperInterface<EmailSent, EmailSentDto> {

    MapperInterface<EmailSent, EmailSentDto> INSTANCE = Mappers.getMapper(EmailSentMapper.class);

    @Override
    EmailSentDto toDto(EmailSent model);

    @Override
    EmailSent toModel(EmailSentDto emailSentDto);

    @Override
    List<EmailSentDto> toDtoList(List<EmailSent> dtoList);

}

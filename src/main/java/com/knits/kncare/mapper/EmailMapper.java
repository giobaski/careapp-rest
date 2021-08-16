package com.knits.kncare.mapper;

import com.knits.kncare.dto.EmailDto;
import com.knits.kncare.model.Email;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface EmailMapper extends MapperInterface<Email, EmailDto> {

    @Override
    EmailDto toDto(Email model);

    @Override
    Email toModel(EmailDto emailDto);

    @Override
    List<EmailDto> toDtoList(List<Email> dtoList);
}
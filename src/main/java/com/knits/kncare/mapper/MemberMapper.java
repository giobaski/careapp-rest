package com.knits.kncare.mapper;

import com.knits.kncare.mapper.MapperInterface;
import com.knits.kncare.dto.MemberDto;
import com.knits.kncare.model.Member;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;


/**
 * For all the available features and annotations see:
 * https://mapstruct.org/documentation/stable/reference/html/
 */
@Mapper(componentModel="spring")
public interface MemberMapper extends MapperInterface<Member, MemberDto> {

    @Named("toMemberDto")
    @Override
    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
    MemberDto toDto(Member model);


}

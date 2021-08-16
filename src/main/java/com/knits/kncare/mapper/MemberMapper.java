package com.knits.kncare.mapper;

import com.knits.kncare.dto.MemberDto;
import com.knits.kncare.model.Member;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


/**
 * For all the available features and annotations see:
 * https://mapstruct.org/documentation/stable/reference/html/
 */
@Mapper(componentModel="spring", disableSubMappingMethodsGeneration = true)

public interface MemberMapper extends MapperInterface<Member, MemberDto> {

    @Named("toMemberDto")
    @Override
    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
    MemberDto toDto(Member model);


    Set<MemberDto> toDtoSet(Set<Member> models);

}

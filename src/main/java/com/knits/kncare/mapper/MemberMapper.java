package com.knits.kncare.mapper;

import com.knits.kncare.dto.MemberDto;
import com.knits.kncare.model.Member;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


/**
 * For all the available features and annotations see:
 * https://mapstruct.org/documentation/stable/reference/html/
 */
@Mapper(componentModel="spring", disableSubMappingMethodsGeneration = true)

public interface MemberMapper extends CycleAvoidingMapperInterface<Member, MemberDto> {

    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);


    @Override
    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
    MemberDto toDto(Member model);

    @Override
    Member toModel(MemberDto memberDto);

    @Override
    List<MemberDto> toDtoList(List<Member> models);

    Set<MemberDto> toDtoSet(Set<Member> models);

}

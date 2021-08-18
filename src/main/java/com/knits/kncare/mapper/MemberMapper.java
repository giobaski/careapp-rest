package com.knits.kncare.mapper;

import com.knits.kncare.dto.MemberDto;
import com.knits.kncare.model.Member;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;
import java.util.Set;


/**
 * For all the available features and annotations see:
 * https://mapstruct.org/documentation/stable/reference/html/
 */
@Mapper(componentModel="spring", injectionStrategy = InjectionStrategy.FIELD)
public interface MemberMapper extends MapperInterface<Member, MemberDto> {

//    @Named("toMemberDto")
    @Override
    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
    MemberDto toDto(Member model);

    @Override
    Member toModel(MemberDto memberDto);

    @Override
    List<MemberDto> toDtoList(List<Member> modelList);

    @Override
    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    Set<Member> toModelSet(Set<MemberDto> memberDtos);
}

package com.knits.kncare.mapper;

import com.knits.kncare.dto.MemberDto;
import com.knits.kncare.dto.RoleDto;
import com.knits.kncare.model.Member;
import com.knits.kncare.model.Role;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * For all the available features and annotations see:
 * https://mapstruct.org/documentation/stable/reference/html/
 */
@Mapper(componentModel="spring")
public interface RoleMapper extends MapperInterface<Role, RoleDto> {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    @Override
    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
    RoleDto toDto(Role model);

    @Override
    Role toModel(RoleDto dto);

    @Override
    List<RoleDto> toDtoList(List<Role> models);

}
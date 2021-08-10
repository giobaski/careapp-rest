package com.knits.kncare.mapper;

import com.knits.kncare.dto.GroupDto;
import com.knits.kncare.model.Group;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel="spring")
public interface GroupMapper extends MapperInterface<Group, GroupDto> {

    GroupMapper INSTANCE = Mappers.getMapper(GroupMapper.class);


    @Override
    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
    GroupDto toDto(Group model);

    @Override
    Group toModel(GroupDto dto);

    @Override
    List<GroupDto> toDtoList(List<Group> models);
}

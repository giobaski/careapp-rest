package com.knits.kncare.mapper;

import com.knits.kncare.dto.GroupDto;
import com.knits.kncare.model.Group;
import org.mapstruct.*;

import java.util.Set;

@Mapper(
        componentModel = "spring",
        uses = {
                GroupMembershipMapper.class
        },
        injectionStrategy = InjectionStrategy.FIELD
)
public interface GroupMapper extends MapperInterface<Group, GroupDto> {

    @Override
    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
    @Mapping(source = "model.groupMemberships", target = "groupMemberships", ignore = true)
//    @Mapping(source = "model.groupMemberships", target = "memberIds", qualifiedByName = "memberId")
//    @Mapping(source = "model.groupMemberships", target = "members", qualifiedByName = "member")
//    @Mapping(source = "model.groupMemberships", target = "groupMemberships", qualifiedByName = "groupDtoMapping")
    GroupDto toDto(Group model);

    @Override
    @BeanMapping(ignoreByDefault = true)
    @Mapping(source = "dto.name", target = "name")
    @Mapping(source = "dto.description", target = "description")
    @Mapping(source = "dto.groupMemberships", target = "groupMemberships", qualifiedByName = "toModelGroupMembership")
    Group toModel(GroupDto dto);

    @Override
    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    Set<Group> toModelSet(Set<GroupDto> groupDtos);
}

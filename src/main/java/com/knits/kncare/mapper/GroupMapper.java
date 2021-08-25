package com.knits.kncare.mapper;

import com.knits.kncare.dto.EmailDto;
import com.knits.kncare.dto.GroupDto;
import com.knits.kncare.dto.MemberDto;
import com.knits.kncare.model.Email;
import com.knits.kncare.model.Group;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                GroupMembershipMapper.class
        }
)
public interface GroupMapper extends CycleAvoidingMapperInterface<Group, GroupDto> {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "members", ignore = true)
    @Mapping(target = "groupMemberships", ignore = true)
    void updateGroupFromDto(GroupDto dto, @MappingTarget Group entity);


}

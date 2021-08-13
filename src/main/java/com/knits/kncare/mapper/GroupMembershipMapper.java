package com.knits.kncare.mapper;

import com.knits.kncare.dto.GroupDto;
import com.knits.kncare.dto.GroupMembershipDto;
import com.knits.kncare.dto.MemberDto;
import com.knits.kncare.model.Group;
import com.knits.kncare.model.GroupMembership;
import com.knits.kncare.model.Member;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.Set;

@Mapper(
        componentModel = "spring",
        uses = {
                GroupMapper.class,
                MemberMapper.class
        }
)
public interface GroupMembershipMapper extends MapperInterface<GroupMembership, GroupMembershipDto>{


    @Named("groupDtoMapping")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "member", source = "member")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    GroupMembershipDto toDtoExcludeGroup (GroupMembership groupMembership);


    @Named("employeeDtoMapping")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "group", source = "group")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    GroupMembershipDto toDtoExcludeMember (GroupMembership groupMembership);

    @Named("member")
    @Mapping(target = "id", source = "member.id")
    @Mapping(target = ".", source = "member")
    @Mapping(target = ".", source = "group",ignore = true)
    @Mapping(target = ".", source = "createdAt",ignore = true)
    @Mapping(target = ".", source = "updatedAt",ignore = true)
    @Mapping(target = "groupMemberships", source = ".",ignore = true)
    MemberDto toMemberDto (GroupMembership groupMembership);


    @Named("memberId")
    @BeanMapping(ignoreByDefault = true)
    default Long toMemberIds(GroupMembership groupMembership){
        if (groupMembership.getMember()==null || groupMembership.getMember().getId()==null){
            throw new IllegalStateException("Inconsistent data in GroupMembership "+groupMembership.getId()+". Member id is mandatory.");
        }
        return groupMembership.getMember().getId();
    }

    @Named("groupId")
    @BeanMapping(ignoreByDefault = true)
    default Long toGroupIds(GroupMembership groupMembership){
        if (groupMembership.getMember()==null || groupMembership.getMember().getId()==null){
            throw new IllegalStateException("Inconsistent data in GroupMembership "+groupMembership.getId()+". Group id is mandatory.");
        }
        return groupMembership.getGroup().getId();
    }



   @Named("toModelGroupMembership")
   default Set<GroupMembership> toModelGroupMembership( Set<GroupMembershipDto>  groupMemberships){
        Set<GroupMembership> memberships= new HashSet<>();
        if (groupMemberships!=null){
            for (GroupMembershipDto groupMembershipDto : groupMemberships) {
                memberships.add(toModel(groupMembershipDto));
            }
        }
        return memberships;
    }


}

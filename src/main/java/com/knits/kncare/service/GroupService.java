package com.knits.kncare.service;

import com.knits.kncare.dto.GroupDto;
import com.knits.kncare.dto.search.GroupSearchDto;
import com.knits.kncare.mapper.GroupMapper;
import com.knits.kncare.mapper.MapperInterface;
import com.knits.kncare.mapper.MemberMapper;
import com.knits.kncare.model.Group;
import com.knits.kncare.model.GroupMembership;
import com.knits.kncare.model.Member;
import com.knits.kncare.repository.GroupRepository;
import com.knits.kncare.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class GroupService extends ServiceBase<Group, GroupDto> {

    private final GroupRepository groupRepository;
    private final MemberRepository memberRepository;
    private MemberMapper memberMapper;
    private final GroupMapper groupMapper; //TODO: Use mapper

    public GroupService(MapperInterface<Group, GroupDto> mapper,
                        GroupRepository groupRepository,
                        MemberRepository memberRepository,
                        GroupMapper groupMapper) {
        super(mapper);
        this.groupRepository = groupRepository;
        this.memberRepository = memberRepository;
        this.groupMapper = groupMapper;
    }


    public GroupDto create(GroupDto groupDto) {

        //checking an empty Group name
        if(groupDto.getName().isEmpty()) { throw new RuntimeException("Group Name Should Not be Empty");}
        //checking for duplicated name
        Group existingName = groupRepository.findByName(groupDto.getName());
        if(existingName != null){ throw new RuntimeException(String.format("Group with the name %s already exists",groupDto.getName())); }


        if (CollectionUtils.isEmpty(groupDto.getMemberIds())) {
            log.debug("creating a group without new members");
            return groupMapper.toDto(groupRepository.save(groupMapper.toModel(groupDto)));
        }

        Group group = groupMapper.toModel(groupDto);
        addMembersToGroup(group, groupDto.getMemberIds());
        groupRepository.save(group);

        GroupDto savedGroupDto = groupMapper.toDto(group);
        savedGroupDto.setMemberIds(groupDto.getMemberIds());
        return savedGroupDto;
    }


    public GroupDto update (Long id, GroupDto groupDto){

        Group group = groupRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("There is no group with ID: " + id));


        groupMapper.updateGroupFromDto(groupDto,group);

        addMembersToGroup(group, groupDto.getMemberIds());
        groupRepository.save(group);

        GroupDto updatedGroupDto = groupMapper.toDto(group);
        updatedGroupDto.setMemberIds(groupDto.getMemberIds());
        return updatedGroupDto;
    }


    public void addMembersToGroup(Group group, Set<Long> memberIds) {

        List<Member> members = memberRepository.findByIds(memberIds);

        for (Member member : members) {
            GroupMembership groupMembership = new GroupMembership(group, member);
            group.getGroupMemberships().add(groupMembership);
        }
    }


    public GroupDto getbyId(long id) {
        Optional<GroupDto> existingGroupDto = groupRepository.findById(id).map(groupMapper::toDto);
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(""));
        return groupMapper.toDto(group);
    }

    public Page<GroupDto> search (GroupSearchDto groupSearchDto){
        Page<Group> groups = groupRepository.findAll(groupSearchDto.getSpecification(), groupSearchDto.getPageable());
        return toDtoPage(groups);
    }
}


//Sample:
//groups = {
//          "name": "myFirstGroup",
//          "description": "Group description",
//          "memberIds": [1,2,3]
//         }
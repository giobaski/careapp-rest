package com.knits.kncare.service;

import com.knits.kncare.dto.GroupDto;
import com.knits.kncare.mapper.GroupMapper;
import com.knits.kncare.mapper.GroupMembershipMapper;
import com.knits.kncare.mapper.MapperInterface;
import com.knits.kncare.mapper.MemberMapper;
import com.knits.kncare.model.Group;
import com.knits.kncare.model.GroupMembership;
import com.knits.kncare.model.Member;
import com.knits.kncare.repository.GroupRepository;
import com.knits.kncare.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class GroupService extends ServiceBase<Group, GroupDto> {


    private GroupRepository groupRepository;
    private MemberRepository memberRepository;
    private MemberMapper memberMapper;
    private GroupMapper groupMapper; //TODO: Use mapper
    private GroupMembershipMapper groupMembershipMapper;


    public GroupService(GroupRepository groupRepository,
                        MapperInterface<Group, GroupDto> mapper,
                        MemberRepository memberRepository,
                        MemberMapper memberMapper,
                        GroupMapper groupMapper) {
        super(mapper);
        this.groupRepository = groupRepository;
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
        this.groupMapper = groupMapper;
        this.groupMembershipMapper = groupMembershipMapper;
    }


    public GroupDto create(GroupDto groupDto) {

        if (CollectionUtils.isEmpty(groupDto.getMemberIds())) {
            log.debug("creating a group without new members");
            return groupMapper.toDto(groupRepository.save(groupMapper.toModel(groupDto)));
        }
        return addMembersToGroup(groupDto);

    }

    public GroupDto addMembersToGroup (GroupDto groupDto){
        Group group = groupMapper.toModel(groupDto);
        addMembersToGroup(group, groupDto.getMemberIds());
        groupRepository.save(group);

        GroupDto savedGroupDto = groupMapper.toDto(group);
        savedGroupDto.setMemberIds(groupDto.getMemberIds());
        return savedGroupDto;
    }

    public void addMembersToGroup(Group group, Set<Long> memberIds) {

        List<Member> members = memberRepository.findByIds(memberIds);

        for (Member member : members) {
            GroupMembership groupMembership = new GroupMembership(group, member);
            group.getGroupMemberships().add(groupMembership);
        }
    }


    public Optional<GroupDto> getbyId(long id) {
        Optional<GroupDto> existingGroupDto = groupRepository.findById(id).map(groupMapper::toDto);
        return existingGroupDto;
    }
}


//Json Sample:
//groups = {
//        "name": "myFirstGroup",
//        "description": "Group description",
//        "memberIds": [1,2,3]
//        }
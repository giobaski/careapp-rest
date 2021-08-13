package com.knits.kncare.service;

import com.knits.kncare.dto.GroupDto;
import com.knits.kncare.mapper.GroupMapper;
import com.knits.kncare.mapper.MapperInterface;
import com.knits.kncare.mapper.MemberMapper;
import com.knits.kncare.model.Group;
import com.knits.kncare.model.GroupMembership;
import com.knits.kncare.model.Member;
import com.knits.kncare.repository.GroupRepository;
import com.knits.kncare.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GroupService extends ServiceBase<Group, GroupDto> {

    private GroupRepository groupRepository;
    private MemberRepository memberRepository;
    private MemberMapper memberMapper;
    private GroupMapper groupMapper; //TODO: Use mapper

    public GroupService(MapperInterface<Group, GroupDto> mapper,
                        GroupRepository groupRepository,
                        MemberRepository memberRepository,
                        MemberMapper memberMapper,
                        GroupMapper groupMapper) {
        super(mapper);
        this.groupRepository = groupRepository;
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
        this.groupMapper = groupMapper;
    }


    public GroupDto create(GroupDto groupDto) {

        if(groupDto.getMemberIds() == null){
            System.out.println("creating a group without new members");
            return groupMapper.toDto(groupRepository.save(groupMapper.toModel(groupDto)));
        }
        Group group = groupMapper.toModel(groupDto);
//        group.setMemberIds(groupDto.getMemberIds());
        return addMembersToGroup(group);
    }


    public GroupDto update (Long id, GroupDto groupDto){

        Group group = groupRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("There is no group with ID: " + id.toString()));
        group.setMemberIds(groupDto.getMemberIds());  //adding Set of Ids of new members
        return addMembersToGroup(group);
    }


    public GroupDto addMembersToGroup (Group group) {

        Set<GroupMembership> memberships = group.getGroupMemberships();
        for (Long id : group.getMemberIds()) {
            Optional<Member> member = memberRepository.findById(id);
            if (member.isPresent()) {

                GroupMembership groupMembership = new GroupMembership();
                groupMembership.setGroup(group);
                groupMembership.setMember(member.get());

                memberships.add(groupMembership);
            }
        }
        group.getGroupMemberships().addAll(memberships);
        return groupMapper.toDto(groupRepository.save(group));
    }


    public GroupDto getbyId(long id) {
        Optional<GroupDto> existingGroupDto = groupRepository.findById(id).map(groupMapper::toDto);
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(""));
        return groupMapper.toDto(group);
    }

    public Page<GroupDto> search (GroupDto groupDto){
        Page<Group> groups = groupRepository.findAll(groupDto.getSpecification(), groupDto.getPageable());
        return toDtoPage(groups);
    }
}


//Sample:
//groups = {
//          "name": "myFirstGroup",
//          "description": "Group description",
//          "memberIds": [1,2,3]
//         }
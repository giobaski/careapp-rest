package com.knits.kncare.service;

import com.knits.kncare.dto.EmployeeDtoTest;
import com.knits.kncare.dto.GroupDto;
import com.knits.kncare.dto.MemberDto;
import com.knits.kncare.mapper.GroupMapper;
import com.knits.kncare.mapper.MapperInterface;
import com.knits.kncare.mapper.MemberMapper;
import com.knits.kncare.model.Group;
import com.knits.kncare.model.GroupMembership;
import com.knits.kncare.model.Member;
import com.knits.kncare.repository.GroupRepository;
import com.knits.kncare.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class GroupService extends ServiceBase<Group, GroupDto> {

    private GroupRepository groupRepository;
    private MemberRepository memberRepository;
    private MemberMapper memberMapper;
    private GroupMapper groupMapper; //TODO: Use mapper

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

    }


    public GroupDto create(GroupDto groupDto) {
        // A. group without members
        if (groupDto.getMemberIds().isEmpty()) {
            Group createdGroup = groupRepository.save(mapper.toModel(groupDto));
            //Log it here
            return mapper.toDto(createdGroup);
        }

        // B. group with members
        Set<Long> listOfMembersId = groupDto.getMemberIds();
//        Set<GroupMembership> memberships = groupDto.getGroupMemberships();
        for (Long id : listOfMembersId) {
            // Get existing member by id
            Optional<MemberDto> existingMember = memberRepository.findById(id).map(memberMapper::toDto);

            if (existingMember.isPresent()) {
                //1.
                MemberDto member = existingMember.get();
                //2.creating membership
                GroupMembership groupMembership = new GroupMembership(groupMapper.toModel(groupDto), memberMapper.toModel(member));
                //3. adding the member to a groupMembership
                groupDto.getGroupMemberships().add(groupMembership);
//                memberships.add(groupMembership);
            }
        }
        //4.
//        groupDto.getGroupMemberships().addAll(memberships);
        //4. save
        Group group_Model = groupMapper.toModel(groupDto);
        return groupMapper.toDto(groupRepository.save(groupMapper.toModel(groupDto)));  // modify this returing of dtos

//        return mapper.toDto(createdGroup);
    }

//    public void addMembersToGroup (){ }
}

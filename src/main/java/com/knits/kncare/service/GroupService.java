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

        if(groupDto.getMemberIds() == null){
            System.out.println("creating a group without new members");
            groupMapper.toModel(groupDto);
            return groupMapper.toDto(groupRepository.save(groupMapper.toModel(groupDto)));
        }
        return addMembersToGroup(groupDto);

    }


    public GroupDto addMembersToGroup (GroupDto groupDto){
        Group group = groupMapper.toModel(groupDto);
        Set<Long> setOfNewMembersId = groupDto.getMemberIds();
        for (Long id : setOfNewMembersId) {

            Optional<Member> existingMember = memberRepository.findById(id);

            if (existingMember.isPresent()) {

                Member member = existingMember.get();

                //move this outside loop later
                GroupMembership groupMembership = new GroupMembership(group, member);
                boolean anyMatch = group.getGroupMemberships().stream()
                        .anyMatch(m -> m.equals(groupMembership));

                if (!anyMatch){
                    group.getGroupMemberships().add(groupMembership);

                }

            }
        }
        return groupMapper.toDto(groupRepository.save(group));  //merging error
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
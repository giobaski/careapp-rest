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

import java.util.List;
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


    //
    public GroupDto create(GroupDto groupDto) {

        if(groupDto.getMemberIds() == null){
            System.out.println("creating a group without new members");
            groupMapper.toModel(groupDto);
            return groupMapper.toDto(groupRepository.save(groupMapper.toModel(groupDto)));
        }
        return addMembersToGroup(groupDto); //creating a group with new members
    }


    //re-write
    public GroupDto addMembersToGroup (GroupDto groupDto){
        Group group = groupMapper.toModel(groupDto);
        List<Long> membersId = groupDto.getMemberIds();
        for (Long id : membersId) {

            Optional<Member> member = memberRepository.findById(id);

            if (member.isPresent()) {

                Member member_ = member.get();

                //move this outside loop later?
                GroupMembership groupMembership = new GroupMembership();
                groupMembership.setGroup(group);
                groupMembership.setMember(member_);

                boolean anyMatch = group.getGroupMemberships().stream()
                        .anyMatch(m -> m.equals(groupMembership));

                if (!anyMatch){
                    group.getGroupMemberships().add(groupMembership);
                }
            }
        }
        return groupMapper.toDto(groupRepository.save(group));  //merging error
    }


    //re-write
    public GroupDto update (Long id, GroupDto groupDto){

        Group group = groupRepository.findById(id).get();  //Optional, if presents add exceptions....
        List<GroupMembership> memberships = group.getGroupMemberships();

        List<Long> membersId = groupDto.getMemberIds();
        for (Long memberId : membersId) {

            Optional<Member> member = memberRepository.findById(memberId);

            if (member.isPresent()) {

                Member member_ = member.get();

                GroupMembership groupMembership = new GroupMembership();
                groupMembership.setGroup(group);
                groupMembership.setMember(member_);

                memberships.add(groupMembership);

//                boolean anyMatch = group.getGroupMemberships().stream()
//                        .anyMatch(m -> m.equals(groupMembership));
//
//                if (!anyMatch){
//                    group.getGroupMemberships().add(groupMembership);
//                }
            }
        }
        group.getGroupMemberships().addAll(memberships);
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
package com.knits.kncare.service;

import com.knits.kncare.dto.MemberDto;
import com.knits.kncare.dto.pages.JsonPageImpl;
import com.knits.kncare.dto.search.MemberSearchDto;
import com.knits.kncare.mapper.MapperInterface;
import com.knits.kncare.model.Member;
import com.knits.kncare.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberService extends ServiceBase<Member, MemberDto>{

    private final MemberRepository memberRepository;
    private final EmployeeService employeeService;


    public MemberService(MapperInterface<Member, MemberDto> mapper,
                         MemberRepository memberRepository,
                         EmployeeService employeeService) {
        super(mapper);
        this.memberRepository = memberRepository;
        this.employeeService = employeeService;
    }


    public MemberDto add (MemberDto memberDto) {
        //TODO: Check before saving whether member with same employee_id exists or not

        //1) check by pdm id that this employee exists
//        employeeService.search(memberDto.getEmployee().getPdmId());


        //2) validate that this employee has been not already added as member
        memberRepository.f



        //3 assign onBoardDate to now
        memberDto.setOnBoardDate(LocalDate.now());   // Probably Needs to change to LocalDate


        Member createdMember = memberRepository.save(toModel(memberDto));
        return toDto(createdMember);
    }


    public Optional<Member> getById(long id) {
        return memberRepository.findById(id);
    }

    public void delete(Long id){
        memberRepository.deleteById(id);
    }
    public void deleteAll(){
        memberRepository.deleteAll();
    }

    public Page<MemberDto> search(MemberSearchDto memberSearchDto) {
        Page<Member> memberPage = memberRepository.findAll(memberSearchDto.getSpecification(), memberSearchDto.getPageable());
        return new JsonPageImpl<>(toDtoList(memberPage.getContent()), memberSearchDto.getPageable(), memberSearchDto.getPageable().getPageSize());
    }
}

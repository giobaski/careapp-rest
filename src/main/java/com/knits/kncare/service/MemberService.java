package com.knits.kncare.service;

import com.knits.kncare.dto.EmployeeDto;
import com.knits.kncare.dto.MemberDto;
import com.knits.kncare.dto.pages.JsonPageImpl;
import com.knits.kncare.dto.search.EmployeeSearchDto;
import com.knits.kncare.dto.search.MemberSearchDto;
import com.knits.kncare.mapper.MapperInterface;
import com.knits.kncare.model.Member;
import com.knits.kncare.model.ems.Employee;
import com.knits.kncare.repository.EmployeeRepository;
import com.knits.kncare.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class MemberService extends ServiceBase<Member, MemberDto>{

    private final MemberRepository memberRepository;
    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;


    public MemberService(MapperInterface<Member, MemberDto> mapper,
                         MemberRepository memberRepository,
                         EmployeeService employeeService,
                         EmployeeRepository employeeRepository) {
        super(mapper);
        this.memberRepository = memberRepository;
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }


    public MemberDto add (MemberDto memberDto) {

        Long pdmId = memberDto.getEmployee().getPdmId();

        //1. check against EMS that this employee still exists (by pdm id)
        EmployeeSearchDto employeeSearchDto = new EmployeeSearchDto();
        employeeSearchDto.setPdmId(pdmId);
        Page<EmployeeDto> employeeFromEMS = employeeService.search(employeeSearchDto);
        if(employeeFromEMS.isEmpty()){
            throw new RuntimeException(String.format("No Such Employee with pdm ID : %s", pdmId.toString()));
        }

        //2. validate that this employee has been not already added as member
        Optional<Member> onboardedMember = memberRepository.findByEmployeePdmId(pdmId);// throw exception here
        if(onboardedMember.isPresent()){
            throw new RuntimeException(String.format("Employee with pdm ID : %s has already added", pdmId.toString()));
        }

        //3. assign onBoardDate to now()
        memberDto.setOnBoardDate(LocalDate.now());

        //4. onboard employee as care member
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

package com.knits.kncare.repository;

import com.knits.kncare.dto.search.MemberSearchDto;
import com.knits.kncare.model.Member;
import com.knits.kncare.model.ems.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@Profile("IT")
@DataJpaTest
public class MemberRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private MemberRepository memberRepository;



//    @Test
//    public void findMembersByAreaOfResponsibility(){
//        MemberSearchDto memberSearch = new MemberSearchDto();
//        memberSearch.setInternationalName("Mary");
//
//        Employee employee = new Employee();
//        employee.setInternationalName("Mary Smith");
//        employeeRepository.save(employee);
//
//        Member member = new Member();
//        member.setOnBoardDate(LocalDateTime.now());
//        member.setOffBoardDate(LocalDateTime.now());
//        member.setEmployee(employeeRepository.findFirstByOrderByIdAsc());
//
//        memberRepository.save(member);
//
//        assertThat(memberRepository.findByAreaOfResponsibility(memberSearch.getCountry())).isNotEmpty();
//
//    }
}

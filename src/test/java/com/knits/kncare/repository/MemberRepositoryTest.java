package com.knits.kncare.repository;

import com.knits.kncare.dto.MemberSearch;
import com.knits.kncare.model.Member;
import com.knits.kncare.model.ems.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class MemberRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private MemberRepository memberRepository;



//    @Test
//    public void findMembersByAreaOfResponsibility(){
//        MemberSearch memberSearch = new MemberSearch();
//        memberSearch.setInternationalName("Mary");
//
//        Employee employee = new Employee();
//        employee.setInternationalName("Mary Smith");
//        employeeRepository.save(employee);
//        Member member = new Member();
//        member.setOnBoardDate(LocalDateTime.now());
//        member.setOffBoardDate(LocalDateTime.now());
//        member.setEmployee(employeeRepository.findFirstByOrderByIdAsc());
//        memberRepository.save(member);
//
//        Specification<Member> spec = memberRepository.findByAreaOfResponsibility(memberSearch);
//        assertThat(memberRepository.findAll(Specification.where(spec))).isNotEmpty();
//
//    }
}

package com.knits.kncare.service;

import com.knits.kncare.dto.MemberDto;
import com.knits.kncare.dto.MemberSearch;
import com.knits.kncare.mapper.MapperInterface;
import com.knits.kncare.model.Member;
import com.knits.kncare.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService extends ServiceBase<Member, MemberDto>{

    private final MemberRepository repository;

    public MemberService(MemberRepository memberRepository, MapperInterface<Member, MemberDto> mapper) {
        super(mapper);
        this.repository = memberRepository;
    }

    public List<Member> getAll() { return repository.findAll(); }

    public Optional<Member> getById(long id) {
        return repository.findById(id);
    }

    public Member Add(Member member) {
        return repository.save(member);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
    public void deleteAll(){
        repository.deleteAll();
    }

    public Page<Member> searchMember(MemberSearch memberSearch) {
         Specification<Member> spec = super.getSpecification();
       Member member = new Member();
      return toDtoPage(repository.findAll(employeeSearch.search(spec, employeeSearch),employee.getPageable()));
    }
}

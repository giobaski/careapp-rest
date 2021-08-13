package com.knits.kncare.service;

import com.knits.kncare.dto.MemberDto;
import com.knits.kncare.dto.search.MemberSearchDto;
import com.knits.kncare.mapper.MapperInterface;
import com.knits.kncare.model.Member;
import com.knits.kncare.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

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

    public Page<MemberDto> search(MemberSearchDto memberSearch) {

        List<Member> members = repository.findByAreaOfResponsibility(memberSearch.getCountry());

        return new PageImpl<>(toDtoList(members));
    }

}

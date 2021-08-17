package com.knits.kncare.service;

import com.knits.kncare.dto.MemberDto;
import com.knits.kncare.dto.MemberSearch;
import com.knits.kncare.mapper.MapperInterface;
import com.knits.kncare.model.Member;
import com.knits.kncare.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public Member add(Member member) {
        return repository.save(member);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
    public void deleteAll(){
        repository.deleteAll();
    }

    public Page<MemberDto> search(MemberSearch memberSearch, Pageable pageable) {
        Specification<Member> members = repository.findByAreaOfResponsibility(memberSearch);
        List<MemberDto> memberDtos = toDtoList(repository.findAll(Specification.where(members)));
        return new PageImpl<>(memberDtos, pageable, memberDtos.size());
    }

    public Page<MemberDto> searchByCountry(Long countryId, Pageable pageable) {
        List<MemberDto> memberDtos = toDtoList(repository.findByCountry(countryId));
        return new PageImpl<>(memberDtos, pageable, memberDtos.size());
    }

}

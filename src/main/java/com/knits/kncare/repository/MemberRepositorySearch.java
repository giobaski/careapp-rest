package com.knits.kncare.repository;

import com.knits.kncare.dto.MemberSearch;
import com.knits.kncare.model.Member;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface MemberRepositorySearch {
    Specification<Member> findByAreaOfResponsibility(com.knits.kncare.dto.MemberSearch memberSearch);
}

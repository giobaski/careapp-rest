package com.knits.kncare.repository;

import com.knits.kncare.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositorySearch, JpaSpecificationExecutor<Member> {
}

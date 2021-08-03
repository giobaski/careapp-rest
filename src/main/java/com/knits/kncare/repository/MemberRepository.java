package com.knits.kncare.repository;

import com.knits.kncare.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, JpaSpecificationExecutor<Member> {
    @Query("select u from Member u where u.employee.internationalName like %?1")
    List<Member> findByFirstnameEndsWith(String internationalName);
}

package com.knits.kncare.repository;

import com.knits.kncare.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Set;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositorySearch, JpaSpecificationExecutor<Member> {
    @Query("select u from Member u where u.employee.internationalName like %?1")
    List<Member> findByFirstnameEndsWith(String internationalName);

    @Query( "select m from Member m INNER JOIN FETCH m.employee e where m.id in :ids" )
    List<Member> findByIds(@Param("ids") Set<Long> memberIds);
}

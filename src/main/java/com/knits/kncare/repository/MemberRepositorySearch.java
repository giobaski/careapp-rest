package com.knits.kncare.repository;

import com.knits.kncare.dto.search.MemberSearchDto;
import com.knits.kncare.model.Member;
import java.util.List;

public interface MemberRepositorySearch {
    List<Member> findByAreaOfResponsibility(MemberSearchDto memberSearch);
}

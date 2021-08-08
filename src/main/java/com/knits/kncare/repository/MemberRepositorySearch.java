package com.knits.kncare.repository;

import com.knits.kncare.dto.MemberSearch;
import com.knits.kncare.model.Member;
import java.util.List;

public interface MemberRepositorySearch {
    List<Member> findByAreaOfResponsibility(com.knits.kncare.dto.MemberSearch memberSearch);
}

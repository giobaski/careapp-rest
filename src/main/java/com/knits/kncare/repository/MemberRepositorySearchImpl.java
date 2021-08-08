package com.knits.kncare.repository;

import com.knits.kncare.model.Member;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class MemberRepositorySearchImpl implements MemberRepositorySearch {

    @PersistenceContext
    EntityManager em;
    @Override
    public List<Member> findByAreaOfResponsibility(com.knits.kncare.dto.MemberSearch memberSearch) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Member> query = builder.createQuery(Member.class);

        Root<Member> member = query.from(Member.class);
        List<Predicate> predicates = new ArrayList<>();

        if (memberSearch.getInternationalName() != null) {
            predicates.add(builder.like(member.get("employee").get("internationalName"), "%" + memberSearch.getInternationalName() + "%"));
        }
        if (memberSearch.getNationality() != null) {
            predicates.add(builder.like(member.get("employee").get("nationality").get("name"), "%" + memberSearch.getNationality() + "%"));
        }
        if (memberSearch.getBusinessUnit()!= null) {
            predicates.add(builder.like(member.get("employee").get("businessUnit").get("name"), "%" + memberSearch.getBusinessUnit() + "%"));
        }
        if (memberSearch.getManagementGroup() != null) {
            predicates.add(builder.like(member.get("employee").get("managementGroup").get("name"), "%" + memberSearch.getManagementGroup()+ "%"));
        }
        if (memberSearch.getWorkingPosition()!= null) {
            predicates.add(builder.like(member.get("employee").get("workingPosition").get("name"), "%" + memberSearch.getWorkingPosition()+ "%"));
        }
        query.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(query).getResultList();
    }
}

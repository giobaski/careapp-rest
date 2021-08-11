package com.knits.kncare.repository;

import com.knits.kncare.dto.MemberSearch;
import com.knits.kncare.model.Member;
import com.knits.kncare.model.ems.Office;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class MemberRepositorySearchImpl implements MemberRepositorySearch {

    private final String EMPLOYEE = "employee";
    private final String ID = "id";
    private final String INTERNATIONAL_NAME = "internationalName";
    private final String NATIONALITY = "nationality";
    private final String OFFICE = "office";
    private final String BUSINESS_UNIT = "businessUnit";
    private final String MANAGEMENT_GROUP = "managementGroup";
    private final String COST_CENTER = "costCenter";

    @PersistenceContext
    EntityManager em;
    @Override
    public List<Member> findByAreaOfResponsibility(MemberSearch memberSearch) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Member> query = builder.createQuery(Member.class);

        Root<Member> member = query.from(Member.class);
        List<Predicate> predicates = new ArrayList<>();

        if (memberSearch.getInternationalName() != null) {
            predicates.add(builder.like(member.get(EMPLOYEE).get(INTERNATIONAL_NAME), "%" + memberSearch.getInternationalName() + "%"));
        }
        if (memberSearch.getNationality() != null) {
            predicates.add(builder.equal(member.get(EMPLOYEE).get(NATIONALITY).get(ID), memberSearch.getNationality()));
        }
        if (memberSearch.getCountry() != null) {
            predicates.add(builder.equal(member.get(EMPLOYEE).get(OFFICE).get(ID), memberSearch.getCountry()));
        }
        if (memberSearch.getBusinessUnit()!= null) {
            predicates.add(builder.equal(member.get(EMPLOYEE).get(BUSINESS_UNIT).get(ID), memberSearch.getBusinessUnit()));
        }
        if (memberSearch.getManagementGroup() != null) {
            predicates.add(builder.equal(member.get(EMPLOYEE).get(MANAGEMENT_GROUP).get(ID), memberSearch.getManagementGroup()));
        }
        if (memberSearch.getCostCenter()!= null) {
            predicates.add(builder.equal(member.get(EMPLOYEE).get(COST_CENTER).get(ID), memberSearch.getCostCenter()));
        }
        query.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(query).getResultList();
    }
}

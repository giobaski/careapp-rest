package com.knits.kncare.repository;

import com.knits.kncare.dto.MemberSearch;
import com.knits.kncare.model.Member;
import com.knits.kncare.model.ems.Office;
import org.springframework.data.jpa.domain.Specification;


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

    @Override
    public Specification<Member> findByAreaOfResponsibility(MemberSearch memberSearch) {

        Specification<Member> spec = Specification.where(null);
        if (memberSearch.getInternationalName() != null) {
            spec = spec.and((member, cq, cb) -> cb.like(member.get(EMPLOYEE).get(INTERNATIONAL_NAME), "%" + memberSearch.getInternationalName() + "%"));
        }
        if (memberSearch.getNationality() != null) {
            spec = spec.and((member, cq, cb) -> cb.equal(member.get(EMPLOYEE).get(NATIONALITY).get(ID), memberSearch.getNationality()));
        }
        if (memberSearch.getCountry() != null) {
            spec = spec.and((member, cq, cb) -> cb.equal(member.get(EMPLOYEE).get(OFFICE).get(ID), memberSearch.getCountry()));
        }
        if (memberSearch.getBusinessUnit()!= null) {
            spec = spec.and((member, cq, cb) -> cb.equal(member.get(EMPLOYEE).get(BUSINESS_UNIT).get(ID), memberSearch.getBusinessUnit()));
        }
        if (memberSearch.getManagementGroup() != null) {
            spec = spec.and((member, cq, cb) -> cb.equal(member.get(EMPLOYEE).get(MANAGEMENT_GROUP).get(ID), memberSearch.getManagementGroup()));
        }
        if (memberSearch.getCostCenter()!= null) {
            spec = spec.and((member, cq, cb) -> cb.equal(member.get(EMPLOYEE).get(COST_CENTER).get(ID), memberSearch.getCostCenter()));
        }
        return spec;

    }
}

package com.knits.kncare.dto;

import com.knits.kncare.model.Member;
import com.knits.kncare.model.ems.Employee;
import com.knits.kncare.utils.Specifications;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

public class MemberSearch {



//    public Specification<Member> search(Specification<Member> spec, MemberSearch memberSearch) {
//        if (Strings.isNotBlank(memberSearch.getFirstName())){
//            spec = spec.and(Specifications.specLike("firstName", "%" + memberSearch.getFirstName() + "%")) ;
//        }
//        if (Strings.isNotBlank(memberSearch.getLastName())){
//            spec = spec.and(Specifications.specLike("lastName", "%" + memberSearch.getLastName() + "%")) ;
//        }
//        if (Strings.isNotBlank(memberSearch.getInternationalName())){
//            spec = spec.and(Specifications.specLike("internationalName", "%" + memberSearch.getInternationalName() + "%")) ;
//        }
//        if (Strings.isNotBlank(memberSearch.getTitle())){
//            spec = spec.and(Specifications.specLike("title", "%" + memberSearch.getTitle() + "%")) ;
//        }
//        if (memberSearch.getNationality() != null){
//            spec = spec.and(Specifications.specEquals("nationality", memberSearch.getNationality().getId()));
//        }
//        if (memberSearch.getBusinessUnit() != null){
//            spec = spec.and(Specifications.specEquals("businessUnit", memberSearch.getBusinessUnit().getId()));
//        }
//
//        return spec;
//    }
}

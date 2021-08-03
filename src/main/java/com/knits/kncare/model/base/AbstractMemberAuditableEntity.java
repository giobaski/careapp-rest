package com.knits.kncare.model.base;

import com.knits.kncare.model.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractMemberAuditableEntity extends AbstractAuditableEntity {

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private Member createdBy;
}

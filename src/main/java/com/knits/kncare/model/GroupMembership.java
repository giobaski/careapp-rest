package com.knits.kncare.model;

import com.knits.kncare.model.base.AbstractMemberAuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "member_group")
public class GroupMembership extends AbstractMemberAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "ID")
    private Member member;


    //Custom Constructor
    public GroupMembership(Group group, Member member) {
        this.group = group;
        this.member = member;
    }
}

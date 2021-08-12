package com.knits.kncare.model;

import com.knits.kncare.model.base.AbstractMemberAuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupMembership)) return false;
        GroupMembership groupMembership = (GroupMembership) o;
        return Objects.equals(getGroup().getId(), groupMembership.getGroup().getId())
                && Objects.equals(getMember().getId(), groupMembership.getMember().getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

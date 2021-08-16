package com.knits.kncare.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.knits.kncare.model.base.AbstractMemberAuditableEntity;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "\"group\"") //group is a reserved word in sql
public class Group extends AbstractMemberAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<GroupMembership> groupMemberships = new HashSet<>();

    @Transient
    private Set<Long> memberIds;

    @Transient
    public Set<Member> getGroupMembers() {
        return groupMemberships.stream()
                .map(GroupMembership::getMember)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return Objects.equals(getName(), group.getName());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

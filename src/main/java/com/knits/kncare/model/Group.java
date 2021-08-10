package com.knits.kncare.model;

import com.knits.kncare.model.base.AbstractMemberAuditableEntity;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@Data
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
    private Set<GroupMembership> groupMemberships = new HashSet<>();;
}

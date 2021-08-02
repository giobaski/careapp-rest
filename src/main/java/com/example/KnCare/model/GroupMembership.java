package com.example.KnCare.model;

import com.example.KnCare.model.Group;
import com.example.KnCare.model.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "member_groups")
public class GroupMembership {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    Group group;

    @ManyToOne
    @JoinColumn(name = "member_id")
    Member member;
}

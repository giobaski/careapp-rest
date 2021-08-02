package com.example.KnCare.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "practices")
public class Practice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    private byte[] content;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToMany()
    @JoinTable(
            name = "PRACTICE_TAGS",
            joinColumns = @JoinColumn(name = "TAGS_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PRACTICES_ID", referencedColumnName = "ID")
    )
    private Set<Tag> tags;



}
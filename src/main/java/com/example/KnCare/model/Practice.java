package com.example.KnCare.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
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

    @Size(min=3, max=100)
    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "member_id")
    Member member;

    @OneToMany(mappedBy = "practice")
    Set<PracticeTags> practiceTags;

}

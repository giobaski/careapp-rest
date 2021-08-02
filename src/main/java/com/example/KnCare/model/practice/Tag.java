package com.example.KnCare.model.practice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany()
    @JoinTable(
            name = "PRACTICE_TAGS",
            joinColumns = @JoinColumn(name = "TAGS_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PRACTICES_ID", referencedColumnName = "ID")
    )
    private Set<Practice> practices;
}

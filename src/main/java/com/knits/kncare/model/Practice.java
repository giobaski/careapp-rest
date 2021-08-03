package com.knits.kncare.model;

import com.knits.kncare.model.base.AbstractMemberAuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "practice")
public class Practice extends AbstractMemberAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Lob
    @Column(name = "content")
    private byte[] content;

    @ManyToMany()
    @JoinTable(
            name = "practice_tags",
            joinColumns = @JoinColumn(name = "practice_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id")
    )
    private Set<Tag> tags;

    @ManyToMany()
    @JoinTable(
            name = "practice_tags",
            joinColumns = @JoinColumn(name = "practice_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "rate_id", referencedColumnName = "id")
    )
    private List<Rate> rates = new ArrayList<>();


}

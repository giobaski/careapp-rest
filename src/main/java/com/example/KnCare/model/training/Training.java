package com.example.KnCare.model.training;

import com.example.KnCare.model.Member;
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
@Table(name = "trainings")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String author;

    private String created_at;

    private String updated_at;

    @ManyToOne
    @JoinColumn(name = "TRAINING_PATH_ID", referencedColumnName = "ID")
    private TrainingPath trainingPath;

    @ManyToMany
    @JoinTable(name = "training_members",
            joinColumns = @JoinColumn(name = "MEMBER_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "TRAINING_ID", referencedColumnName = "ID")
    )
    private Set<Member> members;
}

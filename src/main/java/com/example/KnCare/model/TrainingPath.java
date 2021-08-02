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
@Table(name= "training_paths")
public class TrainingPath {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @OneToMany(mappedBy = "trainingPath")
    Set<MemberTrainingPath> memberTrainingPaths;

    @OneToMany(mappedBy = "trainingPath")
    Set<TrainingPathTrainings> trainingPathTrainings;
}

package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "training_trails")
public class TrainingTrail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;


    @OneToMany(mappedBy = "training_trail", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Training> trainings;

    public TrainingTrail(String name, Set<Training> trainings) {
        this.name = name;
        this.trainings = trainings;
    }

    public TrainingTrail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(Set<Training> trainings) {
        this.trainings = trainings;
    }
}

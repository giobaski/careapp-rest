package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "trainings")
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "training_trails_id", nullable = false)
    private TrainingTrail trainingTrail;


    public Training(String name, TrainingTrail trainingTrail) {
        this.name = name;
        this.trainingTrail = trainingTrail;
    }

    public Training() {
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

    public TrainingTrail getTrainingTrail() {
        return trainingTrail;
    }

    public void setTrainingTrail(TrainingTrail trainingTrail) {
        this.trainingTrail = trainingTrail;
    }
}

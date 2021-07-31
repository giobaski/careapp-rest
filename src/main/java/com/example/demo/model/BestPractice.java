package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "best_practices")
public class BestPractice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public BestPractice(String name) {
        this.name = name;
    }

    public BestPractice() {
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
}

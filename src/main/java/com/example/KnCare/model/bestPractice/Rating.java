package com.example.KnCare.model.bestPractice;

public enum Rating {
    LOW(1),
    MEDIUM(2),
    HIGH(3);

    int rate;

    Rating(int rate){
        this.rate = rate;
    }
}

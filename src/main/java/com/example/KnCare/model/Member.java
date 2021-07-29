package com.example.KnCare.model;

import javax.persistence.*;

@Entity
@Table(name= "care_members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //TODO: Using String for date type, just for testing
    private String onBoardDate;

    private String offBoardDate;

    @OneToOne()
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    Employee employee;
}

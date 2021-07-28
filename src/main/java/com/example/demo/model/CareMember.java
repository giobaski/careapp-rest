package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "care_members")
public class CareMember {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date onBoardDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    public CareMember(Date onBoardDate, Employee employee) {
        this.onBoardDate = onBoardDate;
        this.employee = employee;
    }

    public CareMember() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOnBoardDate() {
        return onBoardDate;
    }

    public void setOnBoardDate(Date onBoardDate) {
        this.onBoardDate = onBoardDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

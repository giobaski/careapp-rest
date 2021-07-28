package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String FirstName;

    private String LastName;

    private String Email;

    private String Title;

    private String InternationalFirstName;

    private String InternationalLastName;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<CareMember> careMembers;

    public Employee(String firstName, String lastName, String email, String title, String internationalFirstName, String internationalLastName, Group group, Set<CareMember> careMembers) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Title = title;
        InternationalFirstName = internationalFirstName;
        InternationalLastName = internationalLastName;
        this.group = group;
        this.careMembers = careMembers;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getInternationalFirstName() {
        return InternationalFirstName;
    }

    public void setInternationalFirstName(String internationalFirstName) {
        InternationalFirstName = internationalFirstName;
    }

    public String getInternationalLastName() {
        return InternationalLastName;
    }

    public void setInternationalLastName(String internationalLastName) {
        InternationalLastName = internationalLastName;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Set<CareMember> getCareMembers() {
        return careMembers;
    }

    public void setCareMembers(Set<CareMember> careMembers) {
        this.careMembers = careMembers;
    }
}

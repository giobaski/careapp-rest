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
@Table(name = "trainingpaths")  //TrainingCollection?
public class TrainingPath {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String start_date;

    private String end_date;

    @OneToMany(mappedBy = "trainingPath", fetch = FetchType.EAGER)
    private Set<Training> trainings;

    @ManyToMany
    @JoinTable(name = "trainingpath_members",
            joinColumns = @JoinColumn(name = "MEMBER_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "TRAININGPATH_ID", referencedColumnName = "ID"))
    private Set<Member> members;

}

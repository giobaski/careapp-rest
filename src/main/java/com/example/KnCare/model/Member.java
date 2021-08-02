package com.example.KnCare.model;

import com.example.KnCare.model.bestPractice.BestPractice;
import com.example.KnCare.model.training.Training;
import com.example.KnCare.model.training.TrainingPath;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.example.KnCare.utils.Specifications;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;


import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name= "care_members")
public class Member extends ModelBase<Member> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;            //TODO: add index

    @Column(name = "on_board_date", nullable = false)
    private String onBoardDate; //TODO: Using String for date type, just for testing

    @Column(name = "off_board_date", nullable = false)
    private String offBoardDate;

    @OneToOne(cascade= CascadeType.ALL, fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")

    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    private CareRole role;

    @ManyToMany
    @JoinTable(name = "group_members",
            joinColumns = @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "MEMBER_ID", referencedColumnName = "ID"))
    private Set<Group> groups;

    @ManyToMany
    @JoinTable(name = "training_members",
            joinColumns = @JoinColumn(name = "MEMBER_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "TRAINING_ID", referencedColumnName = "ID"))
    private Set<Training> trainings;

    @ManyToMany
    @JoinTable(name = "trainingpath_members",
            joinColumns = @JoinColumn(name = "MEMBER_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "TRAININGPATH_ID", referencedColumnName = "ID"))
    private Set<TrainingPath> trainingpaths;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private Set<BestPractice> bestPractices;
  
  
  
    @Override
    public Specification<Member> getSpecification() {
        if (Strings.isNotBlank(onBoardDate)){
            return Specifications.specLike("onBoardDate", onBoardDate);
        }
        if (Strings.isNotBlank(offBoardDate)){
            return Specifications.specLike("offBoardDate", offBoardDate);
        }
        return null;
    }

}

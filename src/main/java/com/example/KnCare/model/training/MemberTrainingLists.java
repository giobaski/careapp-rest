package com.example.KnCare.model.training;

import com.example.KnCare.model.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "training_list_members")
public class MemberTrainingLists {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "training_id")
    TrainingList trainingList;

    @ManyToOne
    @JoinColumn(name = "member_id")
    Member member;
}

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
@Table(name= "member_training_paths")
public class MemberTrainingPath {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "training_id")
    TrainingPath trainingPath;

    @ManyToOne
    @JoinColumn(name = "member_id")
    Member member;
}

package com.example.KnCare.model;

import com.example.KnCare.model.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "emails")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private byte[] content;

    @ManyToOne()
    @JoinColumn(name = "sender_id")
    private Member sender;

    @ManyToOne()
    @JoinColumn(name = "recipient_id")
    private Member recipient;
}

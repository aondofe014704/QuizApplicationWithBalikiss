package com.semicolon.quizapplication.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;
@Entity
@Setter
@Getter
@Table(name = "Questions")
public class Questions {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private String question;
    private String answer;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    @Enumerated(EnumType.STRING)
    private Level level;
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToOne
    private User user;
}

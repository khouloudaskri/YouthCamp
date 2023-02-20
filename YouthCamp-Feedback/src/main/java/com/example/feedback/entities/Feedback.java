package com.example.feedback.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Feedback implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idFeedback;
    private String Subject;
    private String Description;
    // @Temporal(TemporalType.DATE)
    private LocalDate dateFeedback;




}

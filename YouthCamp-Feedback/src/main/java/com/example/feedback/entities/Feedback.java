package com.example.feedback.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Enumerated(EnumType.STRING)
    private  Subject Sub;
    private String Description;
    // @Temporal(TemporalType.DATE)
    private LocalDate dateFeedback;
    @JsonIgnore
    @ManyToOne
    User user;
    @JsonIgnore

    private Integer nbrw;



}

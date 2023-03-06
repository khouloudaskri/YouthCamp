package com.example.feedback.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Transport implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idTransport;
    private String Departure;
    private String Destination;


    // @Temporal(TemporalType.DATE)
    private LocalDate DateTransport;
    private Integer NombrePlaces;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private User user;

}

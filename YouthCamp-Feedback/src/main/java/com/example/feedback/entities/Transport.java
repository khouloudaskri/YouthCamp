package com.example.feedback.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
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

}

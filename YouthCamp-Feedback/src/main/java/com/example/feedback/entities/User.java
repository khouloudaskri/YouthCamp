package com.example.feedback.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idUser; // Clé primaire
    private String firstName;
    private String lastName;
    private String age;
    private String sexe;
    private String email;
    private String password;
    private Integer phone;
    @OneToMany( cascade = CascadeType.ALL, mappedBy = "user")
    @JsonIgnore
    private Set<Feedback> feedbacks;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
    @JsonIgnore
    private Transport transport;
    @OneToMany( cascade = CascadeType.ALL, mappedBy = "userTicket")
    @JsonIgnore
    private Set<TransportTicket> transportTickets;
}

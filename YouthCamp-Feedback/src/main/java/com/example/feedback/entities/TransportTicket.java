package com.example.feedback.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TransportTicket implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idTransportTicket;
    private Integer Prix;
    @ManyToOne
    @JsonIgnore
    User userTicket;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    Transport transport;

}

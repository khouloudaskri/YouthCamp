package tn.esprit.crud_forum.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Message implements Serializable {
    //idMes:integer
    //contentMes:String
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idMsg;
    private String contentMsg;
    @Temporal(TemporalType.DATE)
    private Date msgdate;
    @Enumerated(EnumType.STRING)
    private TypeMessage typeMessage;

    //Relation ManyToOne Message-user
    @ManyToOne(cascade = CascadeType.ALL)
    User user;
}

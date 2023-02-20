package tn.esprit.crud_forum.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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

}

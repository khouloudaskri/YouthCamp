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
public class Publication implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idPub;
    private String content;
    @Temporal(TemporalType.DATE)
    private Date pubDate;
    @Enumerated(EnumType.STRING)
    private TypePublication typePublication;
}

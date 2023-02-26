package tn.esprit.crud_forum.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MotInterdit implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idMot;
    private String mot;

    /*private String mot;

    public MotInterdit(String mot) {
        this.mot = mot;
    }

    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }*/

    //ManyToOne Mot-user
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    MotInterdit motInterdit;
}

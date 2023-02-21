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
public class Publication implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idPub;
    private String content;
    @Temporal(TemporalType.DATE)
    private Date pubDate;
    @Enumerated(EnumType.STRING)
    private TypePublication typePublication;

    //Relation ManyToMany user-Publication
    @ManyToMany(mappedBy = "publications", cascade = CascadeType.ALL)
    private Set<User> users;
    //Relation OneToMany Publication-Reaction
    @OneToMany (cascade = CascadeType.ALL)
    private Set<Reaction> reactions;
    //Relation OneToMany Publication-Commentaire
    @OneToMany (cascade = CascadeType.ALL)
    private Set<Commentaire> commentaires;
/*

    //Relation
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private Set<Publication> Publications;

 */
}

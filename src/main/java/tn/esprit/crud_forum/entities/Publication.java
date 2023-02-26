package tn.esprit.crud_forum.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pubDate;

    @Enumerated(EnumType.STRING)

    private TypePublication typePublication;

    //Relation ManyToMany user-Publication
    @JsonIgnore
    @ManyToMany(mappedBy = "publications", cascade = CascadeType.ALL)
    private Set<User> users;
    //Relation OneToMany Publication-Reaction
    @JsonIgnore
    @OneToMany (cascade = CascadeType.ALL)
    private Set<Reaction> reactions;
    //Relation OneToMany Publication-Commentaire
    @JsonIgnore
    @OneToMany (cascade = CascadeType.ALL)
    private Set<Commentaire> commentaires;

}

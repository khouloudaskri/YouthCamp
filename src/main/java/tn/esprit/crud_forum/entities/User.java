package tn.esprit.crud_forum.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="iduser")
    private Integer iduser; // Clé primaire
    private String firstName;
    private String lastName;
    private String age;
    private String sexe;
    private String email;
    private String password;
    private Integer phone;


/*
    /////////chedya_Forum////
    //Relation ManyToMany user-Publication
    @JsonIgnore
    @ManyToMany(cascade =CascadeType.ALL)
    private <Publicattion> publications;
    //Relation OneToMany user-Reaction
    @OneToMany(cascade = CascadeTpye.All)
    Private Set <Reaction> reactions;

    //Relation OneToMany user-Commentaire
    @OneToMany(cascade = CascadeTpye.All)
    Private Set <Commentaire> commentaires;

    //Relation OneToMany user-Message
    @OneToMany (cascade= CascadeType.All, mappedBy="user")
    Private set <Message> messages;
    //Relation OneToMany user-Reaction
    @OneToMany(cascade = CascadeTpye.All)
    Private Set <Reaction> reactions;
*/
}


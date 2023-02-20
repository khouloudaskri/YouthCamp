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
public class Reaction implements Serializable {

   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private Integer idReac;
   private Integer numberOfReaction;
   @Enumerated(EnumType.STRING)
   private TypeReaction typeReaction;

}

package tn.esprit.crud_forum.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Commentaire implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idCom;
    private String commentText;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate commentDate;
}

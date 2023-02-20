package tn.esprit.crud_forum.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.crud_forum.entities.Commentaire;
import tn.esprit.crud_forum.entities.Publication;
import tn.esprit.crud_forum.services.ICommentaire;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Commentaire")
public class CommentaireRestController {
    ICommentaire commentaireService;
    //Afficher les Commentaires
    @GetMapping("/retrieve-all-Commentaires")
    public List<Commentaire> getCommentaire() {
        List<Commentaire> commentaireList = commentaireService.retrieveAllCommentaire();
        return commentaireList;
    }
    //
    @GetMapping("/retrieve-Commentaire/{commentaire-id}")
    public Commentaire retrieveCommentaire(@PathVariable("commentaire-id") Integer idCom) {
        return commentaireService.retrieveCommentaire(idCom);
    }

    //Ajouter commentaire
    @PostMapping("/add-commentaire")
    public Commentaire addPublication(@RequestBody Commentaire c) {
        Commentaire commentaire = commentaireService.addCommentaire(c);
        return commentaire;
    }

    // supprimer commentaire
    @DeleteMapping("/remove-Commentaire/{commentaire}")
    public void deleteCommentiare(@PathVariable("commentaire") Integer idCom) {
        commentaireService.deleteCommentaire(idCom);
    }

    //Modifier commentaire
    @PutMapping("/update-Commentaire")
    public Commentaire updateCommentaire(@RequestBody Commentaire c) {
        Commentaire commentaire= commentaireService.updateCommentaire(c);
        return commentaire;
    }

}

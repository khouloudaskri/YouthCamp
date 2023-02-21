package tn.esprit.crud_forum.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.crud_forum.entities.Reaction;
import tn.esprit.crud_forum.services.IReaction;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Reaction")
public class ReactionRestController {
    IReaction reactionService;

    //Afficher les Reaction
    @GetMapping("/retrieve-all-reation")
    public List<Reaction> getReactions() {
        List<Reaction> reactionList = reactionService.retrieveAllReaction();
        return reactionList;
    }
    //
    @GetMapping("/retrieve-reaction/{reaction-id}")
    public Reaction retrieveReaction(@PathVariable("reaction-id") Integer idReac) {
        return reactionService.retrieveReaction(idReac);
    }
    //Ajouter reaction
    @PostMapping("/add-reaction")
    public Reaction addReaction(@RequestBody Reaction r) {
        Reaction reaction = reactionService.addReaction(r);
        return reaction;
    }
    // supprimer reac
    @DeleteMapping("/remove-Reaction/{reaction}")
    public void deleteReaction(@PathVariable("reaction") Integer idReac) {
        reactionService.deleteReaction(idReac);
    }
    //Modifier
    @PutMapping("/update-Reaction")
    public Reaction updateReaction(@RequestBody Reaction r) {
        Reaction reaction= reactionService.updateReaction(r);
        return reaction;
    }

}

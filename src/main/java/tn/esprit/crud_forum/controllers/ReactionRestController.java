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
    /*   //fonction like/dislike/Sad/haha
    ////////////////////////////////////////////
     @RestController
     @RequestMapping("/posts/{postId}/reactions")
public class ReactionController {

    @Autowired
    private ReactionRepository reactionRepository;

    @Autowired
    private PostRepository postRepository;

    // Récupère toutes les réactions pour un post spécifique
    @GetMapping
    public List<Reaction> getAllReactionsForPost(@PathVariable Long postId) {
        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        return reactionRepository.findByPost(post);
    }

    // Crée une nouvelle réaction pour un post spécifique
    @PostMapping
    public Reaction createReaction(@PathVariable Long postId, @Valid @RequestBody Reaction reaction) {
        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        reaction.setPost(post);
        return reactionRepository.save(reaction);
    }

    // Met à jour une réaction existante
    @PutMapping("/{reactionId}")
    public Reaction updateReaction(@PathVariable Long postId, @PathVariable Long reactionId,
            @Valid @RequestBody Reaction reactionRequest) {
        if (!postRepository.existsById(postId)) {
            throw new ResourceNotFoundException("Post", "id", postId);
        }

        return reactionRepository.findById(reactionId).map(reaction -> {
            reaction.setType(reactionRequest.getType());
            // ... mise à jour d'autres propriétés si nécessaire
            return reactionRepository.save(reaction);
        }).orElseThrow(() -> new ResourceNotFoundException("Reaction", "id", reactionId));
    }

    // Supprime une réaction existante
    @DeleteMapping("/{reactionId}")
    public ResponseEntity<?> deleteReaction(@PathVariable Long postId, @PathVariable Long reactionId) {
        if (!postRepository.existsById(postId)) {
            throw new ResourceNotFoundException("Post", "id", postId);
        }

        return reactionRepository.findById(reactionId).map(reaction -> {
            reactionRepository.delete(reaction);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Reaction", "id", reactionId));
    }
}
///////////////////////////
nziiid f repo Reaction
@Repository
public interface ReactionRepository extends JpaRepository<Reaction, Long> {
    List<Reaction> findByPost(Post post);
}
hethyy déja fait repo publucation
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    // ... autres méthodes de recherche si nécessaire
}

///////////////////////

     */

}

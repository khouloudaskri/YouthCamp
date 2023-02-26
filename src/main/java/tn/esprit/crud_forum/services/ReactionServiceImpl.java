package tn.esprit.crud_forum.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.crud_forum.entities.Publication;
import tn.esprit.crud_forum.entities.Reaction;
import tn.esprit.crud_forum.repositories.PublicationRepository;
import tn.esprit.crud_forum.repositories.ReactionRepository;

import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class ReactionServiceImpl implements IReaction {
    @Autowired
    ReactionRepository reactionRepository;
    @Autowired
    PublicationRepository publicationRepository;

    @Override
    public List<Reaction> retrieveAllReaction() {
        return null;
    }

    @Override
   /*  List<Publication> retrieveAllPublication(){
        return reactionRepository.findAll();
    }

    public List<Reaction> retrieveAllReaction(){
        return (List<Publication>)reactionRepository.findAll();
    }*/

    public Reaction addReaction (Reaction r){
        return reactionRepository.save(r);
    }

    public  Reaction updateReaction(Reaction r)
    {
        return reactionRepository.save(r);
    }

    public Reaction retrieveReaction (Integer idReac){
        return reactionRepository.findById(idReac).get();
    }
    public void deleteReaction(Integer idReac){
        Reaction r=retrieveReaction(idReac);
        reactionRepository.delete(r);
    }
    //Affectation Reac To Pub
    public void affectationReactionToPublication(Integer idReac, Integer idPub){
        Reaction r=reactionRepository.findById(idReac).orElse(null);
        Publication p=publicationRepository.findById(idPub).orElse(null);
      //r.getPublications().add(p);
       reactionRepository.save(r);


    }


}

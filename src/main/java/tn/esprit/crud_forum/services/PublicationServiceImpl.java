package tn.esprit.crud_forum.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.crud_forum.entities.Commentaire;
import tn.esprit.crud_forum.entities.MotInterdit;
import tn.esprit.crud_forum.entities.Publication;
import tn.esprit.crud_forum.entities.Reaction;
import tn.esprit.crud_forum.repositories.CommentaireRepository;
import tn.esprit.crud_forum.repositories.MotInterditRepository;
import tn.esprit.crud_forum.repositories.PublicationRepository;
import tn.esprit.crud_forum.repositories.ReactionRepository;

import java.util.List;

@Slf4j
@Service
public class PublicationServiceImpl implements IPublication {
    @Autowired
    private CommentaireRepository commentaireRepository;
    @Autowired
    PublicationRepository publicationRepository;
    @Autowired
    ReactionRepository reactionRepository;
    @Autowired
    MotInterditRepository motInterditRepository;




    @Override
   /*  List<Publication> retrieveAllPublication(){
        return publicationRepository.findAll();
    }
*/
    public List<Publication> retrieveAllPublication(){
        return (List<Publication>)publicationRepository.findAll();
    }
    public Publication addPublication (Publication p){
        ///// detecte les mots interdits en publication/////////
        /*String d;
        d=filter(p.getContent());
        log.info(d);
        p.setContent(d);*/
        /////////////////////////////////////////
        return publicationRepository.save(p);
    }

    public  Publication updatePublication (Publication p)
    {
        return publicationRepository.save(p);
    }

    public Publication retrievePublication (Integer idPub){

        return publicationRepository.findById(idPub).get();
    }
    public void deletePublication(Integer idPub){
        Publication p=retrievePublication(idPub);
        publicationRepository.delete(p);
    }

    //Affectation PubToReaction
  /*  @Override
    public void affectationPublicationToReaction(Integer idReac, Integer idPub) {
        Reaction r=reactionRepository.findById(idReac).orElse(null);
        Publication p=publicationRepository.findById(idPub).orElse(null);
        // r.getPublications().add(p);
        reactionRepository.save(r);
    }
    }
*/

//Affectation PubToReaction
    public void AffecterPublicationToReaction(Integer idReac, Integer idPub){
        Publication p= publicationRepository.findById(idPub).orElse(null);
        Reaction r= reactionRepository.findById(idReac).orElse(null);
        p.getReactions().add(r);
        publicationRepository.save(p);
    }
    //Affectation PubToCommentaire
    public void AffecterPublicationToCommentaire(Integer idCom, Integer idPub){
        Commentaire c= commentaireRepository.findById(idCom).orElse(null);
        Publication p= publicationRepository.findById(idPub).orElse(null);
        p.getCommentaires().add(c);
        publicationRepository.save(p);
    }
 /// Mots Interdits
/* public String filter (String input){
    // List<MotInterdit> motsInterdits = motInterditRepository.findAll();
     String filteredInput=input;
     for (String badWords: MotInterdit){
         filteredInput=filteredInput.replaceAll(badWords, "****" );
     }return filteredInput;
    }

 */
 }

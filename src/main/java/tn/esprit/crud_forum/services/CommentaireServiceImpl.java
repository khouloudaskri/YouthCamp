package tn.esprit.crud_forum.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.crud_forum.entities.Commentaire;
import tn.esprit.crud_forum.entities.MotInterdit;
import tn.esprit.crud_forum.entities.Publication;
import tn.esprit.crud_forum.repositories.CommentaireRepository;
import tn.esprit.crud_forum.repositories.MotInterditRepository;

import java.util.List;

@Slf4j
@Service
public class CommentaireServiceImpl implements ICommentaire {
    @Autowired
    CommentaireRepository commentaireRepository;

    @Override
    public List<Commentaire> retrieveAllCommentaire() {
        return (List<Commentaire>)commentaireRepository.findAll();
    }

    public Commentaire addCommentaire(Commentaire c) {
        ///// detecte les mots interdits en comment-text/////////
        String d;
        d=filter(c.getCommentText());
        log.info(d);
        c.setCommentText(d);
        /////////////////////////////////////////
        return commentaireRepository.save(c);
    }

    public Commentaire updateCommentaire(Commentaire c) {
        return commentaireRepository.save(c);
    }

    public Commentaire retrieveCommentaire (Integer idCom){
        return commentaireRepository.findById(idCom).get();
    }

    @Override
  public void deleteCommentaire(Integer idCom){
        Commentaire c =retrieveCommentaire(idCom);
        commentaireRepository.delete(c);
    }

 //mot interdit
   private static final String[]
         BAD_WORDS={"khra","ham hetha","mandher","hama nkad"};
    public String filter (String input){
        String filteredInput=input;
        for (String badWords: BAD_WORDS){
            filteredInput=filteredInput.replaceAll(badWords, "****" );
        }return filteredInput;
    }

}

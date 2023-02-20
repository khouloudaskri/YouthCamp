package tn.esprit.crud_forum.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.crud_forum.entities.Commentaire;
import tn.esprit.crud_forum.entities.Publication;
import tn.esprit.crud_forum.repositories.CommentaireRepository;

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


}

package tn.esprit.crud_forum.services;

import tn.esprit.crud_forum.entities.Commentaire;
import tn.esprit.crud_forum.entities.Publication;

import java.util.List;

public interface ICommentaire {
    public List<Commentaire> retrieveAllCommentaire();

    public Commentaire addCommentaire (Commentaire c);

    public Commentaire updateCommentaire (Commentaire c);

    public Commentaire retrieveCommentaire (Integer idCom);

    public void deleteCommentaire(Integer idCom);

}

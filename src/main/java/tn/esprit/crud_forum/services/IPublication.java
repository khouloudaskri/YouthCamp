package tn.esprit.crud_forum.services;

import tn.esprit.crud_forum.entities.Publication;

import java.util.List;

public interface IPublication {
    public List<Publication> retrieveAllPublication();

    public Publication addPublication (Publication p);

    public Publication updatePublication (Publication p);

    public Publication retrievePublication (Integer idPub);

    public  void deletePublication(Integer idPub);
    // Affectation Publication To Reaction
    public void AffecterPublicationToReaction(Integer idReac, Integer idPub);
    //Afferctation Pub to Commentaire
    public void AffecterPublicationToCommentaire(Integer idCom, Integer idPub);
}

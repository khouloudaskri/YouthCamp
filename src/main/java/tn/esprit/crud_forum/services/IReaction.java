package tn.esprit.crud_forum.services;

import tn.esprit.crud_forum.entities.Publication;
import tn.esprit.crud_forum.entities.Reaction;

import java.util.List;

public interface IReaction {
    public List<Reaction> retrieveAllReaction();

    public Reaction addReaction (Reaction r);

    public Reaction updateReaction (Reaction r);

    public Reaction retrieveReaction (Integer idReac);

    public  void deleteReaction(Integer idReac);

}

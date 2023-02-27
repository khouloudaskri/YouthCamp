package tn.esprit.crud_forum.services;

import lombok.AllArgsConstructor;
import tn.esprit.crud_forum.entities.Reaction;
import tn.esprit.crud_forum.entities.User;

import java.util.List;

public interface IUser {
    public List<User> retrieveAllUser();

    public User addUser (User u);

    public User updateUser (User u);

    public User retrieveUser (Integer iduser);

    public  void deleteUser(Integer iduser);
    //Afferctation Pub to Commentaire
    public void AffecterUserToReaction(Integer idReac, Integer iduser);
}

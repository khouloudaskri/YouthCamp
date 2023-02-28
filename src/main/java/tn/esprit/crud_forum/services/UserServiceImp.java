package tn.esprit.crud_forum.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.crud_forum.entities.Publication;
import tn.esprit.crud_forum.entities.Reaction;
import tn.esprit.crud_forum.entities.User;
import tn.esprit.crud_forum.repositories.PublicationRepository;
import tn.esprit.crud_forum.repositories.ReactionRepository;
import tn.esprit.crud_forum.repositories.UserRepository;

import java.util.List;

@Service
@Slf4j
public class UserServiceImp implements IUser {
    @Autowired
    private PublicationRepository publicationRepository;
    @Autowired
    ReactionRepository reactionRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> retrieveAllUser() {
        return (List<User>)userRepository.findAll() ;
    }

    @Override
    public User addUser(User u) {
        return userRepository.save(u);
    }

    @Override
    public User updateUser(User u) {
        return userRepository.save(u);
    }

    @Override
    public User retrieveUser(Integer iduser) {
        return userRepository.findById(iduser).get();
    }

    @Override
    public void deleteUser(Integer iduser) {
        User u=retrieveUser(iduser);
        userRepository.delete(u);
    }

    //Affectation UserToRection
    public void AffecterUserToReaction(Integer idReac, Integer iduser){
        User u= userRepository.findById(iduser).orElse(null);
        Reaction r= reactionRepository.findById(idReac).orElse(null);
        u.getReactions().add(r);
        userRepository.save(u);
    }

    //Affectation UserToPublication
    public void AffecterUserToPublication(Integer idPub, Integer iduser){
        User u= userRepository.findById(iduser).orElse(null);
        Publication p= publicationRepository.findById(idPub).orElse(null);
        u.getPublications().add(p);
        userRepository.save(u);
    }

}

package tn.esprit.crud_forum.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.crud_forum.entities.Publication;
import tn.esprit.crud_forum.entities.User;
import tn.esprit.crud_forum.services.IUser;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/User")
public class UserRestController {
    IUser userService;
    //Afficher les users
    @GetMapping("/retrieve-all-user")
    public List<User> getUsers() {
        List<User> userList= userService.retrieveAllUser();
        return userList;
    }
    //
    @GetMapping("/retrieve-User/{user-id}")
    public User retrieveUser(@PathVariable("user-id") Integer iduser) {
        return userService.retrieveUser(iduser);
    }

    //Ajouter user
    @PostMapping("/add-user")
    public User addUser(@RequestBody User u) {
        User user = userService.addUser(u);
        return user;
    }

    // supprimer user
    @DeleteMapping("/remove-User/{user}")
    public void deleteUser(@PathVariable("user") Integer iduser) {
        userService.deleteUser(iduser);
    }

    //Modifier
    @PutMapping("/update-User")
    public User updateUser(@RequestBody User u) {
        User user= userService.updateUser(u);
        return user;
    }


    //Affectation user->reaction
    @PutMapping(value="/affecter-User-Reaction/{Iduser}/{reactionId}")
    public void affecterUserToReaction(@PathVariable("Iduser") Integer iduser,
                                              @PathVariable("reactionId")Integer idReac){
        userService.AffecterUserToReaction(iduser,idReac );
    }

}

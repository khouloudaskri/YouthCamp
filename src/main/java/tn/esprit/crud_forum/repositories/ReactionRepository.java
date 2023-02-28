package tn.esprit.crud_forum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.crud_forum.entities.Reaction;
@Repository
public interface ReactionRepository extends CrudRepository<Reaction, Integer> {
    //Select bel native ml base
    /*@Query(value = "SELECT count(r.number_of_reaction) FROM reaction r  WHERE r.type_reaction="Like"  =false ",
            nativeQuery = true)
    Integer nbReactionValides(@Param("Like"));
    */

}
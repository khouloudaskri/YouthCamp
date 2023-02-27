package tn.esprit.crud_forum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.crud_forum.entities.Reaction;
@Repository
public interface ReactionRepository extends CrudRepository<Reaction, Integer> {
    //Select bel native ml base
    /*@Query(value = "SELECT count(e.montant_contrat) FROM contrat e  WHERE e.date_debut_contrat  > :Db AND e.date_fin_contrat < :Df AND e.archive =false ",
            nativeQuery = true)
    Integer nbContratsValides(@Param("Db") Date startDate,@Param("Df") Date endDate);
    */

}
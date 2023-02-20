package tn.esprit.crud_forum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.crud_forum.entities.Reaction;
@Repository
public interface ReactionRepository extends CrudRepository<Reaction, Integer> {
}
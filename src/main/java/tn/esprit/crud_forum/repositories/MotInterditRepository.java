package tn.esprit.crud_forum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.crud_forum.entities.MotInterdit;
@Repository
public interface MotInterditRepository extends JpaRepository<MotInterdit, Long> {
}

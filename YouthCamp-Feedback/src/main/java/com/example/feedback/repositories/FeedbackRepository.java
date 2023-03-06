package com.example.feedback.repositories;

import com.example.feedback.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    @Query("Select e From Feedback e order by e.nbrw desc")
    public List<Feedback> affichepriorty();
}

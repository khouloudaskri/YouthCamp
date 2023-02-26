package com.example.feedback.repositories;

import com.example.feedback.entities.Feedback;
import com.example.feedback.entities.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Integer> {

}

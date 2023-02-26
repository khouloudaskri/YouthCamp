package com.example.feedback.repositories;

import com.example.feedback.entities.TransportTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportTicketRepository extends JpaRepository<TransportTicket, Integer> {
}

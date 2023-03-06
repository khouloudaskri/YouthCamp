package com.example.feedback.repositories;

import com.example.feedback.entities.TransportTicket;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransportTicketRepository extends JpaRepository<TransportTicket, Integer> {



}

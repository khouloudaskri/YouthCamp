package com.example.feedback.services;

import com.example.feedback.entities.TransportTicket;
import com.example.feedback.interfaces.ITransportTicketService;
import com.example.feedback.repositories.TransportTicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class TransportTicketService implements ITransportTicketService {
    TransportTicketRepository transportTicketRepository;
    @Override
    public TransportTicket addTransportTicket(TransportTicket f) {
        return transportTicketRepository.save(f);    }

    @Override
    public TransportTicket updateTransportTicket(TransportTicket f) {
        return transportTicketRepository.save(f);    }


    @Override
    public List<TransportTicket> retrieveAllTransportTickets() {
        return transportTicketRepository.findAll();    }


    @Override
    public void removeTransportTicket(Integer id) {
         transportTicketRepository.deleteById(id);

    }
}

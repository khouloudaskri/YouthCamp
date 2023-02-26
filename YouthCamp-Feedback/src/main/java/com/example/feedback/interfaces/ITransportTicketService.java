package com.example.feedback.interfaces;

import com.example.feedback.entities.TransportTicket;

import java.util.List;

public interface ITransportTicketService {
    public TransportTicket addTransportTicket(TransportTicket f);
    public TransportTicket updateTransportTicket(TransportTicket f);
    public List<TransportTicket> retrieveAllTransportTickets();
    public  void removeTransportTicket(Integer id);
}

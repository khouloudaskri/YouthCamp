package com.example.feedback.interfaces;

import com.example.feedback.entities.TransportTicket;

import java.util.List;

public interface ITransportTicketService {
    public TransportTicket addTransportTicket(TransportTicket f);
    public TransportTicket updateTransportTicket(TransportTicket f);
    public List<TransportTicket> retrieveAllTransportTickets();
    public  void removeTransportTicket(Integer IdTicket);
    public void assignTransportTicketToUser(Integer IdTicket,Integer IdUser);

    public void assignTransportTicketToTransport(Integer IdTicket,Integer idTransport);
    public double latitude(String city);
    public double longitude(String city);
    public double calculateDistanceCity(String dep,String des);
    public double calculatePrice(String dep,String des);
}

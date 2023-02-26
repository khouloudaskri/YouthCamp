package com.example.feedback.interfaces;

import com.example.feedback.entities.Transport;

import java.util.List;

public interface ITransportService {
    public Transport addTransport(Transport f);
    public Transport updateTransport(Transport f);
    public List<Transport> retrieveAllTransports();
    public  void removeTransport(Integer idTransport);
    public void assignTransportToUser(Integer idTransport,Integer IdUser);
    public double latitude(String city);
    public double longitude(String city);





    }

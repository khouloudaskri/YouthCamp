package com.example.feedback.interfaces;

import com.example.feedback.entities.Transport;
import org.apache.lucene.util.SloppyMath;

import java.util.List;

public interface ITransportService {
    public Transport addTransport(Transport f);
    public Transport updateTransport(Transport f);
    public List<Transport> findtransports();

    public  void removeTransport(Integer idTransport);
    public void assignTransportToUser(Integer idTransport,Integer IdUser);

  /*  public double latitude(String city);
    public double longitude(String city);
    public double calculateDistanceCity(String dep,String des);
    public double calculatePrice(String dep,String des);*/







}

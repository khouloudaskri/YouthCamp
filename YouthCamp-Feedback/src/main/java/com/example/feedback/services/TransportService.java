package com.example.feedback.services;

import com.example.feedback.entities.Transport;
import com.example.feedback.interfaces.ITransportService;
import com.example.feedback.repositories.TransportRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class TransportService implements ITransportService {
    TransportRepository transportRepository;

    public Transport addTransport(Transport f) {
        return transportRepository.save(f);
    }


    public Transport updateTransport(Transport f) {
        return transportRepository.save(f);
    }


    public List<Transport> retrieveAllTransports() {
        return transportRepository.findAll();
    }

    public void removeTransport(Integer idTransport) {
        transportRepository.deleteById(idTransport);

    }
}

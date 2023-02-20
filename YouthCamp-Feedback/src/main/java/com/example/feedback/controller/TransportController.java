package com.example.feedback.controller;

import com.example.feedback.entities.Transport;
import com.example.feedback.interfaces.ITransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Transport")
public class TransportController {
@Autowired
    ITransportService transportService;

    @PostMapping("/AddTransport")
    public Transport addTransport(@RequestBody Transport F) {
        Transport transport = transportService.addTransport(F);
        return transport;
    }

    @GetMapping("/retrieve-all-transports")
    public List<Transport> getTransports() {
        List<Transport> listTransports = transportService.retrieveAllTransports();
        return listTransports;
    }

    @PutMapping("/update-transport")
    public Transport updateTransport(@RequestBody Transport c) {
        Transport transport = transportService.updateTransport(c);
        return transport;
    }
    @DeleteMapping("/remove-transport/{transport-id}")
    public void removeTransport(@PathVariable("transport-id") Integer idTransport) {

        transportService.removeTransport(idTransport);
}}

package com.example.feedback.controller;

import com.example.feedback.entities.TransportTicket;
import com.example.feedback.interfaces.ITransportService;
import com.example.feedback.interfaces.ITransportTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TransportTicket")

public class TransportTicketController {
    @Autowired
    ITransportTicketService transportTicketServiceService;

    @PostMapping("/AddTransportTicket")

    public TransportTicket addTransportTicket(@RequestBody TransportTicket F) {
        TransportTicket transportTicket = transportTicketServiceService.addTransportTicket(F);
        return transportTicket;
    }

    @GetMapping("/retrieve-all-transportTickets")
    public List<TransportTicket> getTransportTickets() {
        List<TransportTicket> listTransportTickets = transportTicketServiceService.retrieveAllTransportTickets();
        return listTransportTickets;
    }

    @PutMapping("/update-transportTicket")
    public TransportTicket updateTransportTicket(@RequestBody TransportTicket c) {
        TransportTicket transportTicket = transportTicketServiceService.updateTransportTicket(c);
        return transportTicket;
    }
    @DeleteMapping("/remove-transport/{transportTicket-id}")
    public void removeTransportTicket(@PathVariable("transport-id") Integer idTransportTicket) {

        transportTicketServiceService.removeTransportTicket(idTransportTicket);
    }
}

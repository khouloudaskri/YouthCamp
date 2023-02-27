package com.example.feedback.controller;

import com.example.feedback.entities.Transport;
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
    @PostMapping("/calculateDistance")
    public double calculateDistanceCity(String dep,String des){
        double d=transportTicketServiceService.calculateDistanceCity(dep,des);
        return d;
    }
    /* public double calculateDistanceCity(String dep,String des) {
         double lat1=transportService.latitude(dep);
 log.info(String.valueOf(lat1));


         double long1=transportService.longitude(dep);
         log.info(String.valueOf(long1));

         double lat2=transportService.latitude(des);
         log.info(String.valueOf(lat2));

         double long2=transportService.longitude(des);
         log.info(String.valueOf(long2));




         double dist = SloppyMath.haversinKilometers(lat1, long1, lat2, long2);
         return dist;
     }*/
    @PostMapping("/calculatePrice")
    public double calculatePrice(String dep,String des){
        double P=transportTicketServiceService.calculatePrice(dep,des);
        return P;
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
    @DeleteMapping("/remove-transportTicket/{transportTicket-id}")
    public void removeTransportTicket(@PathVariable("transport-id") Integer idTransportTicket) {

        transportTicketServiceService.removeTransportTicket(idTransportTicket);
    }
    @PutMapping("/assign-transportTicket-to-user/{Id}/{IdUser}")
    public void assignTransportTicketToUser(@PathVariable("Id") Integer Id,
                                     @PathVariable("IdUser") Integer IdUser) {
        transportTicketServiceService.assignTransportTicketToUser(Id,IdUser);

    }
    @PutMapping("/assign-transportTicket-to-transport/{Id}/{idTransport}")
    public void assignTransportTicketToTransport(@PathVariable("Id") Integer Id,
                                     @PathVariable("idTransport") Integer idTransport) {
        transportTicketServiceService.assignTransportTicketToTransport(Id,idTransport);

    }

}


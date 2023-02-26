package com.example.feedback.controller;

import com.example.feedback.entities.Transport;
import com.example.feedback.interfaces.ITransportService;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.util.SloppyMath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
@RestController
@Slf4j

@RequestMapping("/Transport")
public class TransportController {
@Autowired
    ITransportService transportService;
    /*GeoApiContext context = new GeoApiContext.Builder()
            .apiKey("AIzaSyB_CTuz9tapjxqXcevY-sv5r9Q5JeZ5VUs")
            .build();
*/
    @PostMapping("/AddTransport")
    public Transport addTransport(@RequestBody Transport F) {
        Transport transport = transportService.addTransport(F);
        return transport;
    }
   /* @PostMapping("/CalculateDistanace")
    public double calculateDistanceInMeters(double lat1,double long1,double lat2, double long2) {

        double dist = org.apache.lucene.util.SloppyMath.haversinKilometers(lat1, long1, lat2, long2);
        return dist;
    }*/

    @PostMapping("/calculateDistance")
    public double calculateDistanceCity(String dep,String des) {
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
    }


  /*  @GetMapping("/Latitude")
    public double  maps() {
    GeocodingResult[] results = GeocodingApi.geocode(context);
        double lat = results[0].geometry.location.lat;
        return lat;
    }*/

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
}
    @PutMapping("/assign-Transport/{idTransport}/{IdUser}")
    @ResponseBody
    public void assignTransportToUser(@PathVariable("idTransport") Integer idTransport, @PathVariable("IdUser") Integer IdUser) {
         transportService.assignTransportToUser(idTransport,IdUser);

    }
}

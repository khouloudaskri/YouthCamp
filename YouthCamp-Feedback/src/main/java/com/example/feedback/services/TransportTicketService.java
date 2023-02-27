package com.example.feedback.services;

import com.example.feedback.entities.Feedback;
import com.example.feedback.entities.Transport;
import com.example.feedback.entities.TransportTicket;
import com.example.feedback.entities.User;
import com.example.feedback.interfaces.ITransportTicketService;
import com.example.feedback.repositories.TransportRepository;
import com.example.feedback.repositories.TransportTicketRepository;
import com.example.feedback.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.lucene.util.SloppyMath;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@AllArgsConstructor
@Service
public class TransportTicketService implements ITransportTicketService {
    TransportTicketRepository transportTicketRepository;
    UserRepository userRepository;
    TransportRepository transportRepository;
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
    @Transactional
    public void assignTransportTicketToUser(Integer IdTicket,Integer IdUser)
    {
        TransportTicket T=transportTicketRepository.findById(IdTicket).orElse(null);
        User U=userRepository.findById(IdUser).orElse(null);
        T.setUserTicket(U);
        transportTicketRepository.save(T);

    }


    @Transactional
    public void assignTransportTicketToTransport(Integer Id,Integer idTransport)
    {
        TransportTicket T=transportTicketRepository.findById(Id).orElse(null);
        Transport U=transportRepository.findById(idTransport).orElse(null);
        T.setTransport(U);
        transportTicketRepository.save(T);

    }
    public double latitude(String city) {
        double lat=0;
        String[] Cities = new String[24];
        double[] Latitudes = new double[24];
        Latitudes[0]=36.8665;
        Latitudes[1]=36.7333;
        Latitudes[2]=36.7435;
        Latitudes[3]=37.2768;
        Latitudes[4]=33.8881;
        Latitudes[5]=34.4311;
        Latitudes[6]=36.5072;
        Latitudes[7]=35.6712;
        Latitudes[8]=35.1723;
        Latitudes[9]=33.7072;
        Latitudes[10]=36.1680;
        Latitudes[11]=35.5024;
        Latitudes[12]=36.8093;
        Latitudes[13]=33.3399;
        Latitudes[14]=35.7643;
        Latitudes[15]=36.4513;
        Latitudes[16]=34.7398;
        Latitudes[17]=35.0354;
        Latitudes[18]=36.0887;
        Latitudes[19]=35.8245;
        Latitudes[20]=32.9211;
        Latitudes[21]=33.9185;
        Latitudes[22]=36.8065;
        Latitudes[23]=36.4091;
        Cities[0] = "Ariana";
        Cities[1] = "Beja";
        Cities[2] = "Ben Arous";
        Cities[3] = "Bizerte";
        Cities[4] = "Gabes";
        Cities[5] = "Gafsa";
        Cities[6] = "Jendouba";
        Cities[7] = "Kairouan";
        Cities[8] = "Kassrine";
        Cities[9] = "Kebili";
        Cities[10] = "Kef";
        Cities[11] = "Mahdia";
        Cities[12] = "Manouba";
        Cities[13] = "Mednine";
        Cities[14] = "Monastir";
        Cities[15] = "Nabeul";
        Cities[16] = "Sfax";
        Cities[17] = "Sidi Bouzid";
        Cities[18] = "Siliana";
        Cities[19] = "Sousse";
        Cities[20] = "Tataouine";
        Cities[21] = "Tozeur";
        Cities[22] = "Tunis";
        Cities[23] = "Zaghouan";
        for (int i = 0; i < 24; i++) {
            if (Cities[i].equals(city))
                lat = Latitudes[i];
        }
        return lat;
    }
    public double longitude(String city){
        double lon = 0;
        String[] Cities = new String[24];
        Cities[0] = "Ariana";
        Cities[1] = "Beja";
        Cities[2] = "Ben Arous";
        Cities[3] = "Bizerte";
        Cities[4] = "Gabes";
        Cities[5] = "Gafsa";
        Cities[6] = "Jendouba";
        Cities[7] = "Kairouan";
        Cities[8] = "Kassrine";
        Cities[9] = "Kebili";
        Cities[10] = "Kef";
        Cities[11] = "Mahdia";
        Cities[12] = "Manouba";
        Cities[13] = "Mednine";
        Cities[14] = "Monastir";
        Cities[15] = "Nabeul";
        Cities[16] = "Sfax";
        Cities[17] = "Sidi Bouzid";
        Cities[18] = "Siliana";
        Cities[19] = "Sousse";
        Cities[20] = "Tataouine";
        Cities[21] = "Tozeur";
        Cities[22] = "Tunis";
        Cities[23] = "Zaghouan";
        double[] longitudes = new double[24];
        longitudes[0]=10.1647;
        longitudes[1]=9.1844;
        longitudes[2]=10.2320;
        longitudes[3]=9.8642;
        longitudes[4]=10.0975;
        longitudes[5]=8.7757;
        longitudes[6]=8.7757;
        longitudes[7]=10.1005;
        longitudes[8]=8.8308;
        longitudes[9]=8.9715;
        longitudes[10]=8.7096;
        longitudes[11]=11.0457;
        longitudes[12]=10.0863;
        longitudes[13]=10.4959;
        longitudes[14]=10.8113;
        longitudes[15]=10.7357;
        longitudes[16]=10.7600;
        longitudes[17]=9.4839;
        longitudes[18]=9.3645;
        longitudes[19]=10.6346;
        longitudes[20]=10.4509;
        longitudes[21]=8.1229;
        longitudes[22]=10.1815;
        longitudes[23]=10.1423;
        for (int i = 0; i < 24; i++) {
            if (Cities[i].equals(city))
                lon = longitudes[i];
        }
        return lon;
    }
    public double calculateDistanceCity(String dep,String des) {
        double lat1=latitude(dep);
        double long1=longitude(dep);
        double lat2=latitude(des);
        double long2=longitude(des);
       double dist = SloppyMath.haversinKilometers(lat1, long1, lat2, long2);
        return dist;
    }

    public double calculatePrice(String dep,String des){
        double p;
        double lat1=latitude(dep);
        double long1=longitude(dep);
        double lat2=latitude(des);
        double long2=longitude(des);
        double dist = SloppyMath.haversinKilometers(lat1, long1, lat2, long2);
        if(dist>10 && dist<150) {
            p=dist*0.086;}
        else if (dist>150) {
            p=dist*0.071;
        }
        else
            p=0.850;
        return p;
    }


}

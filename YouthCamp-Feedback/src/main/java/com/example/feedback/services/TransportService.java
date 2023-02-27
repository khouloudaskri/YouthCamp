package com.example.feedback.services;

import com.example.feedback.entities.Transport;
import com.example.feedback.entities.User;
import com.example.feedback.interfaces.ITransportService;
import com.example.feedback.repositories.TransportRepository;
import com.example.feedback.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.util.SloppyMath;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class TransportService implements ITransportService {
    TransportRepository transportRepository;
    UserRepository userRepository;

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
  /*  @Transactional
    public void assignTransportToUser(Integer idTransport,Integer IdUser) {

            User U = userRepository.findById(IdUser).orElse(null);
            Transport T = transportRepository.findById(idTransport).orElse(null);
        if(T.getNombrePlaces()>0) {
            U.getTransports().add(T);
            transportRepository.save(T);
            T.setNombrePlaces(T.getNombrePlaces() - 1);
        }
        else {
            log.info("hhhhhhhhhhhhhhhhhhhhh");
        }
    }*/
  @Transactional
  public void assignTransportToUser(Integer idTransport,Integer IdUser){
      User U = userRepository.findById(IdUser).orElse(null);
      Transport T = transportRepository.findById(idTransport).orElse(null);
      T.setUser(U);
      transportRepository.save(T);



  }


   /* public double latitude(String city) {
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
        log.info(String.valueOf(lat1));


        double long1=longitude(dep);
        log.info(String.valueOf(long1));

        double lat2=latitude(des);
        log.info(String.valueOf(lat2));

        double long2=longitude(des);
        log.info(String.valueOf(long2));




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
    }*/


}

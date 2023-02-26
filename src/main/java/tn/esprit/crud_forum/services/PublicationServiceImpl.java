package tn.esprit.crud_forum.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.crud_forum.entities.Publication;
import tn.esprit.crud_forum.repositories.PublicationRepository;

import java.util.List;

@Slf4j
@Service
public class PublicationServiceImpl implements IPublication {
    @Autowired
    PublicationRepository publicationRepository;
    @Override
   /*  List<Publication> retrieveAllPublication(){
        return publicationRepository.findAll();
    }
*/
    public List<Publication> retrieveAllPublication(){
        return (List<Publication>)publicationRepository.findAll();
    }
    public Publication addPublication (Publication p){
        return publicationRepository.save(p);
    }

    public  Publication updatePublication (Publication p)
    {
        return publicationRepository.save(p);
    }

    public Publication retrievePublication (Integer idPub){

        return publicationRepository.findById(idPub).get();
    }
    public void deletePublication(Integer idPub){
        Publication p=retrievePublication(idPub);
        publicationRepository.delete(p);
    }
}

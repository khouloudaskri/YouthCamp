package tn.esprit.crud_forum.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.crud_forum.entities.MotInterdit;
import tn.esprit.crud_forum.repositories.MotInterditRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetectionMotsInterditsService {
    @Autowired
    private MotInterditRepository repository;

    public List<String> detecterMotsInterdits(String texte) {
        List<MotInterdit> motsInterdits = repository.findAll();
        List<String> interditsDetectes = new ArrayList<>();

        for (MotInterdit motInterdit : motsInterdits) {
            if (texte.contains(motInterdit.getMot())) {
                interditsDetectes.add(motInterdit.getMot());
            }
        }

        return interditsDetectes;
    }
}

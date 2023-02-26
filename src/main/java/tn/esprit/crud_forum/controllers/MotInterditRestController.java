package tn.esprit.crud_forum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.crud_forum.entities.MotInterdit;
import tn.esprit.crud_forum.repositories.MotInterditRepository;

import java.util.List;

@RestController
@RequestMapping("/mots-interdits")
public class MotInterditRestController {
    @Autowired
    private MotInterditRepository repository;

    @GetMapping
    public List<MotInterdit> getMotsInterdits() {
        return repository.findAll();
    }

    @PostMapping
    public MotInterdit ajouterMotInterdit(@RequestBody MotInterdit motInterdit) {
        return repository.save(motInterdit);
    }

    @DeleteMapping("/{id}")
    public void supprimerMotInterdit(@PathVariable Long idmot) {
        repository.deleteById(idmot);
    }

}

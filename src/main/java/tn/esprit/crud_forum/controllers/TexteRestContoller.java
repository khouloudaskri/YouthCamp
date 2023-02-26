package tn.esprit.crud_forum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.crud_forum.services.DetectionMotsInterditsService;

import java.util.List;

@RestController
@RequestMapping("/texte")
public class TexteRestContoller {
    @Autowired
    private DetectionMotsInterditsService detectionMotsInterditsService;

    @PostMapping("/detecter-mots-interdits")
    public ResponseEntity<List<String>> detecterMotsInterdits(@RequestBody String texte) {
        List<String> interditsDetectes = detectionMotsInterditsService.detecterMotsInterdits(texte);

        if (interditsDetectes.isEmpty()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body(interditsDetectes);
        }
    }
}

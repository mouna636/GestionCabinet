package com.projet.GestionCabinet.Controllers;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.projet.GestionCabinet.DTO.CabinetForm;
import com.projet.GestionCabinet.Entities.Cabinet;
import com.projet.GestionCabinet.Services.CabinetService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cabinets")

public class CabinetController {
    @Autowired
    private CabinetService cabinetService;

    @PostMapping("/ajout")
    public ResponseEntity<Cabinet> ajouterCabinetAvecHoraires(@ModelAttribute CabinetForm cabinetForm)
            throws IOException {
        Cabinet nouveauCabinet = cabinetService.AjouterCabinet(cabinetForm);
        return ResponseEntity.ok(nouveauCabinet);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CabinetForm>> getAllCabinets() {
        List<CabinetForm> cabinets = cabinetService.getAllCabinets();
        return new ResponseEntity<>(cabinets, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Cabinet getCabinetById(@PathVariable Long id) {
        return cabinetService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cabinet> modifierCabinet(@PathVariable Long id, @RequestBody CabinetForm cabinetForm) {
        try {
            Cabinet cabinet = cabinetService.modifierCabinet(id, cabinetForm);
            return ResponseEntity.ok(cabinet);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerCabinet(@PathVariable Long id) {
        try {
            cabinetService.supprimerCabinet(id);
            return ResponseEntity.noContent().build(); // Réponse 204 si la suppression est réussie
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build(); // Réponse 404 si le cabinet n'existe pas
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            // Autre gestion des erreurs serveur
        }
    }

    @GetMapping("/search")
    public List<Cabinet> searchCabinetByName(@RequestParam String name) {
        return cabinetService.findCabinetByName(name);
    }

    @GetMapping("/searchadr")
    public List<Cabinet> searchCabinetByAdresse(@RequestParam String adresse) {
        return cabinetService.findCabinetByAdresse(adresse);
    }

}

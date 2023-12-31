package com.projet.GestionCabinet.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.GestionCabinet.Entities.Consultation;
import com.projet.GestionCabinet.Entities.OrdonnancetTraitement;
import com.projet.GestionCabinet.Services.OrdonnancetTraitementServiceImpl;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ordonnanceTraitement")
public class OrdonnancetTraitementController {

    @Autowired
    private OrdonnancetTraitementServiceImpl ordonnancetTraitementService;

    @GetMapping
    public List<OrdonnancetTraitement> getAllOrdonnancetTraitement() {
        return ordonnancetTraitementService.getAllOrdonnancetTraitement();
    }

    @GetMapping("/{id}")
    public OrdonnancetTraitement getOrdonnancetTraitementById(@PathVariable long id) {
        return ordonnancetTraitementService.getOrdonnancetTraitementById(id);
    }

    @PostMapping
   public  OrdonnancetTraitement addOrdonnancetTraitement(@RequestBody OrdonnancetTraitement ordonnancetTraitement) {
        return ordonnancetTraitementService.addOrdonnancetTraitement(ordonnancetTraitement);
    }

    @PutMapping("/{id}")
    public OrdonnancetTraitement updateOrdonnancetTraitement(@PathVariable Long id, @RequestBody OrdonnancetTraitement ordonnancetTraitement) {
        return ordonnancetTraitementService.updateOrdonnancetTraitement(id, ordonnancetTraitement);
    }


    @DeleteMapping("/{id}")
    public void deleteOrdonnancetTraitement(@PathVariable Long id) {
        ordonnancetTraitementService.deleteOrdonnancetTraitement(id);
   }

   //ajout
    @GetMapping("/patient/{id}")
    public List<OrdonnancetTraitement> getOrdonnanceByPatientId(@PathVariable long id){
        return ordonnancetTraitementService.getOrdonnanceByPatientId(id);
    }



    


    
}
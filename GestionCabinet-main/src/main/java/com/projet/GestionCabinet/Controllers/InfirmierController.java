package com.projet.GestionCabinet.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.GestionCabinet.Entities.Infirmier;
import com.projet.GestionCabinet.Services.InfirmierService;

@RestController
@RequestMapping("/infirmiers")
public class InfirmierController {

    @Autowired
    private InfirmierService infirmierService;


    @GetMapping("/")
    public List<Infirmier> getAllInfirmier() {
        return infirmierService.getAllInfirmier();
    }


    @GetMapping("/{id}")
    public Infirmier getInfirmierById(@PathVariable long id) {
        return infirmierService.getInfirmierById(id);
    }


     @PostMapping("/")
     public Infirmier saveInfirmier(@RequestBody Infirmier infirmier) {
        return infirmierService.saveInfirmier(infirmier);
    }


     @PutMapping("/{id}")
     public Infirmier updateInfirmier(@PathVariable Long id, @RequestBody Infirmier updatedInfirmier) {
        return infirmierService.updateInfirmier(id, updatedInfirmier);
     }


     @DeleteMapping("/{id}")
    public void deleteInfirmierById(@PathVariable long id) {
        infirmierService.deleteInfirmierById(id);

    }    
}
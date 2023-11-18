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

import com.projet.GestionCabinet.Entities.Medicament;
import com.projet.GestionCabinet.Services.MedicamentService;



@RestController
@RequestMapping("/medicaments")
public class MedicamentController {

    @Autowired
    private MedicamentService medicamentService;

    @GetMapping("")
    public List<Medicament> getAllMedicament() {
        return medicamentService.getAllMedicaments();
    }

    @GetMapping("/id")
    public Medicament getMedicamentById(@PathVariable long id) {
        return medicamentService.getMedicamentById(id);
    }

    @PostMapping("")
    public Medicament addMedicament(@RequestBody Medicament medicament) {
        return medicamentService.addMedicament(medicament);
    }
    
    @PutMapping("/{id}")
    public Medicament updateMedicament(@PathVariable long id, @RequestBody Medicament medicament) {
        return medicamentService.updateMedicament(id, medicament);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicament(@PathVariable Long id) {
        medicamentService.deleteMedicament(id);
    }
}
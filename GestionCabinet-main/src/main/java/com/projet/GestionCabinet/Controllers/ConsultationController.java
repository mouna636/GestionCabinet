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
import com.projet.GestionCabinet.Services.ConsultationServiceImpl;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/consultations")
public class ConsultationController {

    @Autowired
    private ConsultationServiceImpl consultationService;

    @GetMapping
    public List<Consultation> getAllConsultation() {
        return consultationService.getAllConsultations();
    }

    @GetMapping("/{id}")
    public Consultation getConsultationById(@PathVariable long id) {
        return consultationService.findById(id);
    }

    @PostMapping
    public Consultation saveConsultation(@RequestBody Consultation consultation) {
        return consultationService.add(consultation);
    }

    @PutMapping("/{id}")
    public Consultation updateConsultation(@PathVariable Long id, @RequestBody Consultation updatedConsultation) {
        return consultationService.update(id, updatedConsultation);
    }

    @DeleteMapping("/{id}")
    public void deleteConsultationById(@PathVariable long id) {
        consultationService.delete(id);

    }
}
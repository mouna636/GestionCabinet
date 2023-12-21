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
import com.projet.GestionCabinet.Entities.HoraireTravail;
import com.projet.GestionCabinet.Services.HoraireService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/horaires")
public class HoraireController {

    @Autowired
    private HoraireService horaireService;

    @GetMapping
    public List<HoraireTravail> getHoraires() {
        return horaireService.getAllHoraires();
    }

    @PostMapping("")
    public HoraireTravail addHoraire(@RequestBody HoraireTravail horaire) {
        return horaireService.addHoraire(horaire);
    }

    @GetMapping("cabinet/{id}")
    public List<HoraireTravail> getHoraireTravailByCabinetId(@PathVariable long id) {
        return horaireService.getHoraireTravailByCabinetId(id);
    }

    @GetMapping("/{id}")
    public HoraireTravail getHoraireById(@PathVariable Long id) {
        return horaireService.getHoraire(id);
    }

    @PutMapping("/{id}")
    public HoraireTravail updateHoraire(@PathVariable Long id, @RequestBody HoraireTravail horaire) {
        return horaireService.updateHoraire(id, horaire);
    }

    @DeleteMapping("/{id}")
    public void deleteHoraire(@PathVariable Long id) {
        horaireService.deleteHoraire(id);
    }

}

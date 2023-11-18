package com.projet.GestionCabinet.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projet.GestionCabinet.Entities.HoraireTravail;
import com.projet.GestionCabinet.Services.HoraireService;

@Controller
@RequestMapping("/horaires")
public class HoraireController {
    
    @Autowired
    private HoraireService hs;

    @GetMapping
    public List<HoraireTravail> getHoraires() {
        return hs.getAllHoraires();
    }

    @PostMapping
    public HoraireTravail addHoraire(@RequestBody HoraireTravail horaire) {
        return hs.addHoraire(horaire);
    }
    
     @GetMapping("/{id}")
    public HoraireTravail getHoraireById(@PathVariable Long id) {
        return hs.getHoraire(id);
    }

    @PutMapping("/{id}")
    public HoraireTravail updateHoraire(@PathVariable Long id, @RequestBody HoraireTravail horaire) {
        return hs.updateHoraire(id, horaire);
    }

    @DeleteMapping("/{id}")
    public void deleteHoraire(@PathVariable Long id) {
        hs.deleteHoraire(id);
    }


}

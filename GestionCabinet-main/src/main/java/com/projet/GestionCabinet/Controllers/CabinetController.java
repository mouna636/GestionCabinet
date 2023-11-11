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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.projet.GestionCabinet.Entities.Cabinet;
import com.projet.GestionCabinet.Services.CabinetService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cabinets")

public class CabinetController {
    @Autowired
    private CabinetService cabinetService;

    @GetMapping("")
    public List<Cabinet> getAllCabinets() {
        return cabinetService.getAllCabinets();
    }

    @GetMapping("/{id}")
    public Cabinet getCabinetById(@PathVariable Long id) {
        return cabinetService.findById(id);
    }

    @PostMapping("")
    public Cabinet addCabinet(@RequestBody Cabinet cabinet) {
        return cabinetService.add(cabinet);
    }

    @PutMapping("/{id}")
    public Cabinet updateCabinet(@PathVariable Long id, @RequestBody Cabinet cabinet) {
        return cabinetService.update(id, cabinet);
    }

    @DeleteMapping("/{id}")
    public void deleteCabinet(@PathVariable Long id) {
        cabinetService.delete(id);

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

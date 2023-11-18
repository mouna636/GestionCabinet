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

import com.projet.GestionCabinet.Entities.Rendezvous;
import com.projet.GestionCabinet.Services.RendezvousService;

@Controller
@RequestMapping("/rendezvous")
public class RendezvousController {
    
    @Autowired
    private RendezvousService Rdv;

    @GetMapping
    public List<Rendezvous> getRendezvous() {
        return Rdv.getAllRendezvous();
    }

    @PostMapping
    public Rendezvous addrendezvous(@RequestBody Rendezvous rendezvous) {
        return Rdv.addRendezvous(rendezvous);
    }
    
    @GetMapping("/{id}")
    public Rendezvous getrendezvousById(@PathVariable Long id) {
        return Rdv.getRendezvous(id);
    }

    @PutMapping("/{id}")
    public Rendezvous updaterendezvous(@PathVariable Long id, @RequestBody Rendezvous rendezvous) {
        return Rdv.updateRendezvous(id, rendezvous);
    }

    @DeleteMapping("/{id}")
    public void deleterendezvous(@PathVariable Long id) {
        Rdv.deleteRendezvous(id);
    }


}
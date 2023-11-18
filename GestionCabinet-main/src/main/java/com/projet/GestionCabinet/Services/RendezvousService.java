package com.projet.GestionCabinet.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.projet.GestionCabinet.DAO.RendezvousRepository;
import com.projet.GestionCabinet.Entities.Rendezvous;
;

@Service
public class RendezvousService {

  @Autowired
  private RendezvousRepository RendezvousRep;

  
  public List<Rendezvous> getAllRendezvous() {
    return RendezvousRep.findAll();
  }

  
  public Rendezvous addRendezvous(Rendezvous rendezvous) {
    return RendezvousRep.save(rendezvous);
  }

  
  public Rendezvous getRendezvous(Long id) {
    return RendezvousRep.findById(id).orElse(null);
  }

  
  public Rendezvous updateRendezvous(Long id, Rendezvous rendezvous) {
    Rendezvous existingRendezvous = RendezvousRep.findById(id).orElse(null);
    existingRendezvous.setId(id);
    return RendezvousRep.save(existingRendezvous);
  }

  
  public void deleteRendezvous(Long id) {
    RendezvousRep.deleteById(id);
  }
}
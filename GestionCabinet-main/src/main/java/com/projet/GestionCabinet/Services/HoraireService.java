package com.projet.GestionCabinet.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.GestionCabinet.DAO.HoraireRepository;
import com.projet.GestionCabinet.Entities.HoraireTravail;

@Service
public class HoraireService {

  @Autowired
  private HoraireRepository horaireRep;

  
  public List<HoraireTravail> getAllHoraires() {
    return horaireRep.findAll();
  }

  
  public HoraireTravail addHoraire(HoraireTravail horaireTravail) {
    return horaireRep.save(horaireTravail);
  }

  
  public HoraireTravail getHoraire(Long id) {
    return horaireRep.findById(id).orElse(null);
  }

  
  public HoraireTravail updateHoraire(Long id, HoraireTravail horaireTravail) {
    HoraireTravail existingHoraire = horaireRep.findById(id).orElse(null);
    existingHoraire.setId(id);
    return horaireRep.save(existingHoraire);
  }

  
  public void deleteHoraire(Long id) {
    horaireRep.deleteById(id);
  }
}
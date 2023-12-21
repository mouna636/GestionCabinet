package com.projet.GestionCabinet.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projet.GestionCabinet.DAO.HoraireRepository;

import com.projet.GestionCabinet.Entities.HoraireTravail;

@Service
public class HoraireService implements HoraireServiceImpl {

  @Autowired
  private HoraireRepository horaireRepository;

  @Override
  public List<HoraireTravail> getAllHoraires() {
    return horaireRepository.findAll();
  }

  @Override
  public HoraireTravail addHoraire(HoraireTravail horaireTravail) {
    return horaireRepository.save(horaireTravail);
  }

  @Override
  public HoraireTravail getHoraire(Long id) {
    return horaireRepository.findById(id).orElse(null);
  }

  @Override
  public HoraireTravail updateHoraire(Long id, HoraireTravail horaireTravail) {
    HoraireTravail existingHoraire = horaireRepository.findById(id).orElse(null);
    existingHoraire.setId(id);
    return horaireRepository.save(existingHoraire);
  }

  @Override
  public List<HoraireTravail> getHoraireTravailByCabinetId(Long id) {
    return horaireRepository.getHoraireTravailByCabinetId(id);
  }

  @Override
  public void deleteHoraire(Long id) {
    horaireRepository.deleteById(id);
  }

}
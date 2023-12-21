package com.projet.GestionCabinet.Services;

import java.util.List;

import com.projet.GestionCabinet.Entities.HoraireTravail;

public interface HoraireServiceImpl {
    public List<HoraireTravail> getAllHoraires();

    public HoraireTravail addHoraire(HoraireTravail horaireTravail);

    public HoraireTravail getHoraire(Long id);

    public HoraireTravail updateHoraire(Long id, HoraireTravail horaireTravail);

    public List<HoraireTravail> getHoraireTravailByCabinetId(Long id);

    public void deleteHoraire(Long id);
}

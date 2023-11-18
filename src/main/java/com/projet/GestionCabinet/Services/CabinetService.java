package com.projet.GestionCabinet.Services;

import java.util.List;

import com.projet.GestionCabinet.Entities.Cabinet;

public interface CabinetService {

    public List<Cabinet> getAllCabinets();

    public Cabinet findById(Long id);

    public Cabinet update(Long id, Cabinet cabinet);

    public Cabinet add(Cabinet cabinet);

    public void delete(Long id);

    public List<Cabinet> findCabinetByName(String name);

    public List<Cabinet> findCabinetByAdresse(String adresse);
}

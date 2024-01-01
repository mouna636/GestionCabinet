package com.projet.GestionCabinet.Services;

import java.io.IOException;
import java.util.List;

import com.projet.GestionCabinet.DTO.CabinetForm;
import com.projet.GestionCabinet.Entities.Cabinet;

public interface CabinetService {

    public List<CabinetForm> getAllCabinets();

    public Cabinet findById(Long id);

    public Cabinet modifierCabinet(Long id, CabinetForm cabinetForm) throws IOException;

    public Cabinet AjouterCabinet(CabinetForm cabinetForm) throws IOException;

    public void supprimerCabinet(Long id);

    public List<Cabinet> findCabinetByName(String name);

    public List<Cabinet> findCabinetByAdresse(String adresse);

}

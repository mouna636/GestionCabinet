package com.projet.GestionCabinet.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projet.GestionCabinet.DAO.CabinetRepository;
import com.projet.GestionCabinet.DAO.HoraireRepository;
import com.projet.GestionCabinet.DTO.CabinetForm;
import com.projet.GestionCabinet.Entities.Cabinet;
import com.projet.GestionCabinet.Entities.HoraireTravail;

@Service
public class CabinetServiceImpl implements CabinetService {
    @Autowired
    private CabinetRepository cabinetRepository;
    @Autowired
    private HoraireRepository horaireRepository;

    @Override
    public List<CabinetForm> getAllCabinets() {
        List<CabinetForm> ListCabinet = new ArrayList<>();
        List<Cabinet> cabinets = cabinetRepository.findAll();
        for (Cabinet cabinet : cabinets) {
            CabinetForm cabinetForm = new CabinetForm();
            cabinetForm.setName(cabinet.getName());
            cabinetForm.setAdresse(cabinet.getAdresse());
            cabinetForm.setMatriculefiscale(cabinet.getMatriculefiscale());
            cabinetForm.setSpecialite(cabinet.getSpecialite());
            cabinetForm.setTelephone(cabinetForm.getTelephone());
            cabinetForm.setVille(cabinet.getVille());
            cabinetForm.setHoraires(cabinet.getHoraires());
            ListCabinet.add(cabinetForm);
        }
        return ListCabinet;
    }

    @Override
    public Cabinet findById(Long id) {
        Optional<Cabinet> cabinet = cabinetRepository.findById(id);
        return cabinet.isPresent() ? cabinet.get() : null;

    }

    @Override
    public Cabinet update(Long id, Cabinet cabinet) {
        Optional<Cabinet> existingCabinet = cabinetRepository.findById(id);
        if (existingCabinet.isPresent()) {
            Cabinet updatedCabinet = existingCabinet.get();
            updatedCabinet.setName(cabinet.getName());
            updatedCabinet.setAdresse(cabinet.getAdresse());
            updatedCabinet.setSpecialite(cabinet.getSpecialite());
            updatedCabinet.setTelephone(cabinet.getTelephone());
            updatedCabinet.setMatriculefiscale(cabinet.getMatriculefiscale());

            updatedCabinet.setVille(cabinet.getVille());

            return cabinetRepository.save(updatedCabinet);
        } else {
            return null;
        }
    }

    @Override
    public Cabinet add(Cabinet cabinet) {
        return cabinetRepository.save(cabinet);
    }

    @Override
    public void delete(Long id) {

        cabinetRepository.deleteById(id);
    }

    public List<Cabinet> findCabinetByName(String name) {
        return cabinetRepository.findByName(name);

    }

    @Override
    public List<Cabinet> findCabinetByAdresse(String adresse) {
        return cabinetRepository.findByAdresse(adresse);
    }

    @Override
    public Cabinet AjouterCabinet(CabinetForm cabinetForm) {
        Cabinet cabinet = new Cabinet();
        cabinet.setTelephone(cabinetForm.getTelephone());
        cabinet.setAdresse(cabinetForm.getAdresse());
        cabinet.setMatriculefiscale(cabinetForm.getMatriculefiscale());
        cabinet.setName(cabinetForm.getName());
        cabinet.setSpecialite(cabinetForm.getSpecialite());
        cabinet.setHoraires(cabinetForm.getHoraires());
        Cabinet savedCabinet = cabinetRepository.save(cabinet);
        List<HoraireTravail> horaires = cabinetForm.getHoraires();
        // Association des horaires au cabinet enregistré
        for (HoraireTravail horaire : horaires) {
            horaire.setCabinet(savedCabinet);
            horaireRepository.save(horaire);
        }
        // Mettre à jour le cabinet avec les horaires associés
        savedCabinet.setHoraires(horaires);
        cabinetRepository.save(savedCabinet);

        return savedCabinet;

    }
}
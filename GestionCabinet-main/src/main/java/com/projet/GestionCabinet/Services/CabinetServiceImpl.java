package com.projet.GestionCabinet.Services;

import java.io.IOException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projet.GestionCabinet.DAO.CabinetRepository;
import com.projet.GestionCabinet.DAO.HoraireRepository;

import com.projet.GestionCabinet.DTO.CabinetForm;
import com.projet.GestionCabinet.Entities.Cabinet;
import com.projet.GestionCabinet.Entities.HoraireTravail;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CabinetServiceImpl implements CabinetService {
    @Autowired
    private CabinetRepository cabinetRepository;
    @Autowired
    private HoraireRepository horaireRepository;

    @Override
    public List<CabinetForm> getAllCabinets() {
        return cabinetRepository.findAll().stream().map(Cabinet::getCabinet).collect(Collectors.toList());

    }

    @Override
    public Cabinet findById(Long id) {
        Optional<Cabinet> cabinet = cabinetRepository.findById(id);
        return cabinet.isPresent() ? cabinet.get() : null;

    }

    @Override
    public Cabinet modifierCabinet(Long id, CabinetForm cabinetForm) throws IOException {
        Optional<Cabinet> optionalCabinet = cabinetRepository.findById(id);

        if (optionalCabinet.isPresent()) {
            Cabinet cabinet = optionalCabinet.get();
            cabinet.setTelephone(cabinetForm.getTelephone());
            cabinet.setAdresse(cabinetForm.getAdresse());
            cabinet.setMatriculefiscale(cabinetForm.getMatriculefiscale());
            cabinet.setName(cabinetForm.getName());
            cabinet.setSpecialite(cabinetForm.getSpecialite());
            if (cabinetForm.getImage() != null) {
                cabinet.setImage(cabinetForm.getImage().getBytes());
            }

            cabinet.setVille(cabinetForm.getVille());

            List<HoraireTravail> horaires = cabinetForm.getHoraires();
            List<HoraireTravail> oldHoraires = cabinet.getHoraires();
            if (oldHoraires != null && !oldHoraires.isEmpty()) {
                horaireRepository.deleteAll(oldHoraires);
            }
            for (HoraireTravail horaire : horaires) {
                horaire.setCabinet(cabinet);
                horaireRepository.save(horaire);
            }

            cabinet.setHoraires(horaires);
            Cabinet updatedCabinet = cabinetRepository.save(cabinet);
            return updatedCabinet;
        } else {
            throw new NoSuchElementException("Le cabinet avec l'ID " + id + " n'existe pas.");
        }
    }

    @Override
    public void supprimerCabinet(Long id) {
        // Vérifie si le cabinet existe
        Optional<Cabinet> optionalCabinet = cabinetRepository.findById(id);
        if (optionalCabinet.isPresent()) {
            List<HoraireTravail> horaires = optionalCabinet.get().getHoraires();
            if (horaires != null && !horaires.isEmpty()) {
                horaireRepository.deleteAll(horaires);
            }
            cabinetRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("Le cabinet avec l'ID " + id + " n'existe pas.");
        }
    }

    public List<Cabinet> findCabinetByName(String name) {
        return cabinetRepository.findByName(name);

    }

    @Override
    public List<Cabinet> findCabinetByAdresse(String adresse) {
        return cabinetRepository.findByAdresse(adresse);
    }

    @Override
    public Cabinet AjouterCabinet(CabinetForm cabinetForm) throws IOException {

        Cabinet cabinet = new Cabinet();
        cabinet.setTelephone(cabinetForm.getTelephone());
        cabinet.setAdresse(cabinetForm.getAdresse());
        cabinet.setMatriculefiscale(cabinetForm.getMatriculefiscale());
        cabinet.setName(cabinetForm.getName());
        cabinet.setSpecialite(cabinetForm.getSpecialite());
        cabinet.setImage(cabinetForm.getImage().getBytes());
        cabinet.setVille(cabinetForm.getVille());
        cabinet.setHoraires(cabinetForm.getHoraires());
        Cabinet savedCabinet = cabinetRepository.save(cabinet);
        List<HoraireTravail> horaires = cabinetForm.getHoraires();

        for (HoraireTravail horaire : horaires) {
            horaire.setCabinet(savedCabinet);
            horaireRepository.save(horaire);
        }

        savedCabinet.setHoraires(horaires);
        cabinetRepository.save(savedCabinet);

        return savedCabinet;

    }

}

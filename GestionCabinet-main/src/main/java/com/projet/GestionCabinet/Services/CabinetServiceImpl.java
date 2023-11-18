package com.projet.GestionCabinet.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.GestionCabinet.DAO.CabinetRepository;
import com.projet.GestionCabinet.Entities.Cabinet;

@Service
public class CabinetServiceImpl implements CabinetService {
    @Autowired
    private CabinetRepository cabinetRepository;

    @Override
    public List<Cabinet> getAllCabinets() {

        return cabinetRepository.findAll();
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
            updatedCabinet.setHoraires(cabinet.getHoraires());
            updatedCabinet.setTelephone(cabinet.getTelephone());
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
}
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
    public Cabinet update(Cabinet cabinet) {

        return cabinetRepository.save(cabinet);
    }

    @Override
    public Cabinet add(Cabinet cabinet) {
        return cabinetRepository.save(cabinet);
    }

    @Override
    public void delete(Long id) {
        cabinetRepository.deleteById(id);
    }

}

package com.projet.GestionCabinet.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.GestionCabinet.DAO.InfirmierRepository;
import com.projet.GestionCabinet.Entities.Infirmier;

@Service
public class InfirmierServiceImpl implements InfirmierService{

    @Autowired
    private InfirmierRepository infirmierRepository;


     @Override
    public List<Infirmier> getAllInfirmier() {
        return infirmierRepository.findAll();
    }


    @Override
    public Infirmier getInfirmierById(long id) {
        return infirmierRepository.findById(id).orElse(null);
    }


    @Override
    public Infirmier saveInfirmier(Infirmier infirmier) {
        return infirmierRepository.save(infirmier);
    }


@Override
    public Infirmier updateInfirmier(Long id, Infirmier updatedInfirmier) {
        Infirmier infirmier = infirmierRepository.findById(id).orElse(null);
        infirmier.setNom(updatedInfirmier.getNom());
        infirmier.setPrenom(updatedInfirmier.getPrenom());
        infirmier.setTelephone(updatedInfirmier.getTelephone());
        return infirmierRepository.save(infirmier);
    }


    @Override
    public void deleteInfirmierById(long id) {
        infirmierRepository.deleteById(id);
    }


    
// fi les méthode héthom nét3amlou m3a el Repository deja kolhom "infirmierRepository." wfi controller tél9ahom nafes les méthodes mais tétamel ù3a service tel9aha 

    
}
package com.projet.GestionCabinet.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.GestionCabinet.DAO.OrdonnancetTraitementRepository;
import com.projet.GestionCabinet.Entities.OrdonnancetTraitement;

@Service
public class OrdonnancetTraitementServiceImpl implements OrdonnancetTraitementService {

    @Autowired
    private OrdonnancetTraitementRepository ordonnaceRep;

    @Override
    public List<OrdonnancetTraitement> getAllOrdonnancetTraitement() {
        return ordonnaceRep.findAll();  
    }

    @Override
    public OrdonnancetTraitement getOrdonnancetTraitementById(long id) {
        return ordonnaceRep.findById(id).get();
    }

    @Override
    public OrdonnancetTraitement addOrdonnancetTraitement(OrdonnancetTraitement ordonnancetTraitement) {
        return ordonnaceRep.save(ordonnancetTraitement);
    }

    
    @Override
    public OrdonnancetTraitement updateOrdonnancetTraitement(long id, OrdonnancetTraitement updatedOrdonnance) {
        OrdonnancetTraitement existingOrdonnance = ordonnaceRep.findById(id).orElse(null);

        if (existingOrdonnance != null) {
            existingOrdonnance.setDateOrdonnance(updatedOrdonnance.getDateOrdonnance());
            existingOrdonnance.setMedicaments(updatedOrdonnance.getMedicaments());

            return ordonnaceRep.save(existingOrdonnance);
        } else {
            
            return null;
        }
    }

  

    @Override
    public void deleteOrdonnancetTraitement(Long id) {
        ordonnaceRep.deleteById(id);
    }

    //ajout
    @Override
    public List<OrdonnancetTraitement> getOrdonnanceByPatientId(Long id) {
        return ordonnaceRep.getOrdonnanceByPatientId(id);
    }

    

    
}
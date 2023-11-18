package com.projet.GestionCabinet.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.GestionCabinet.DAO.MedicamentRepository;
import com.projet.GestionCabinet.Entities.Medicament;


@Service
public class MedicamentServiceImpl  implements MedicamentService {

    @Autowired
    private MedicamentRepository medicamentRep;



    @Override
    public List<Medicament> getAllMedicaments() {
        return medicamentRep.findAll();
    }

    @Override
    public Medicament getMedicamentById(long id) {
        return medicamentRep.findById(id).get();
    }

    @Override
    public Medicament addMedicament(Medicament medicament) {
        return medicamentRep.save(medicament);
    }

    @Override
    public Medicament updateMedicament(long id, Medicament medicament) {
        Medicament existingMedicament = medicamentRep.findById(id).orElse(null);

        if (existingMedicament != null) {
            existingMedicament.setNom(medicament.getNom());
            existingMedicament.setPsologie(medicament.getPsologie());
            existingMedicament.setNbrUnite(medicament.getNbrUnite());
            existingMedicament.setQsp(medicament.getQsp());

            return medicamentRep.save(existingMedicament);
        } else {
            
            return null;
        }
    }

    @Override
    public void deleteMedicament(Long id) {
        medicamentRep.deleteById(id);
    }
    
}
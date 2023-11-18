package com.projet.GestionCabinet.Services;

import java.util.List;

import com.projet.GestionCabinet.Entities.Medicament;

public interface MedicamentService {

    List<Medicament> getAllMedicaments();

    Medicament getMedicamentById(long id);

    Medicament addMedicament(Medicament medicament);

    Medicament updateMedicament(long id, Medicament medicament);

    void deleteMedicament(Long id);

}

package com.projet.GestionCabinet.Services;

import java.util.List;

import com.projet.GestionCabinet.Entities.Infirmier;

public interface InfirmierService {

    //siter l'ensemble des methodes de l'interface wna3mloulhom implimetaion fi "InfirmierServiceImpl"

    List<Infirmier> getAllInfirmier();
    Infirmier getInfirmierById(long id);
    Infirmier saveInfirmier(Infirmier infirmier);
    Infirmier updateInfirmier(Long id, Infirmier updatedInfirmier);
    void deleteInfirmierById(long id);
}

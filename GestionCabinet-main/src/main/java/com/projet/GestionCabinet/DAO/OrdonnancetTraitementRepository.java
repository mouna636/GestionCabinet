package com.projet.GestionCabinet.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.GestionCabinet.Entities.Consultation;
import com.projet.GestionCabinet.Entities.OrdonnancetTraitement;

@Repository
public interface OrdonnancetTraitementRepository extends JpaRepository<OrdonnancetTraitement, Long>{

    List<OrdonnancetTraitement> getOrdonnanceByPatientId(Long id);
    
}
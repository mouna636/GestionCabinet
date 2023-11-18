package com.projet.GestionCabinet.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.GestionCabinet.Entities.Medicament;

public interface MedicamentRepository extends JpaRepository<Medicament, Long> {
    
}
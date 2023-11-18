package com.projet.GestionCabinet.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.GestionCabinet.Entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    
}

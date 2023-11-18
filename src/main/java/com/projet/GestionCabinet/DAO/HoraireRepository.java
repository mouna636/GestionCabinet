package com.projet.GestionCabinet.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.GestionCabinet.Entities.HoraireTravail;

public interface HoraireRepository extends JpaRepository<HoraireTravail, Long> {
    
}

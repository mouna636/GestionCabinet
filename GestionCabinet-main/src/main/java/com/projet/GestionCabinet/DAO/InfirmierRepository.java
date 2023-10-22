package com.projet.GestionCabinet.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.GestionCabinet.Entities.Infirmier;

public interface InfirmierRepository extends JpaRepository<Infirmier, Long> {
}
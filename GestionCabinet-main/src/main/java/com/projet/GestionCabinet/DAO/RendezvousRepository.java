package com.projet.GestionCabinet.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.GestionCabinet.Entities.Rendezvous;


public interface RendezvousRepository extends JpaRepository<Rendezvous, Long> {
}
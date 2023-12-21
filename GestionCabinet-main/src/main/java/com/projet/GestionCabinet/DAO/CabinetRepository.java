package com.projet.GestionCabinet.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.projet.GestionCabinet.Entities.Cabinet;

@Repository
public interface CabinetRepository extends JpaRepository<Cabinet, Long> {

    List<Cabinet> findByName(String name);

    List<Cabinet> findByAdresse(String adresse);

}

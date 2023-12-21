package com.projet.GestionCabinet.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.GestionCabinet.Entities.HoraireTravail;

@Repository
public interface HoraireRepository extends JpaRepository<HoraireTravail, Long> {
    public List<HoraireTravail> getHoraireTravailByCabinetId(Long id);

}
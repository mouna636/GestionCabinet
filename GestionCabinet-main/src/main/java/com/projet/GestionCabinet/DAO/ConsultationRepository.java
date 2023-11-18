package com.projet.GestionCabinet.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.GestionCabinet.Entities.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    List<Consultation> getConsultationsByPatientId(Long id);
}

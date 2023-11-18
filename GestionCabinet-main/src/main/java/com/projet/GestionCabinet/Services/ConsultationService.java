package com.projet.GestionCabinet.Services;

import java.util.List;
import com.projet.GestionCabinet.Entities.Consultation;

public interface ConsultationService {

    public List<Consultation> getAllConsultations();

    public Consultation findById(Long id);

    public Consultation update(Long id, Consultation Consultation);

    public Consultation add(Consultation Consultation);

    public void delete(Long id);

    public List<Consultation> getConsultationsByPatientId(Long id);
}

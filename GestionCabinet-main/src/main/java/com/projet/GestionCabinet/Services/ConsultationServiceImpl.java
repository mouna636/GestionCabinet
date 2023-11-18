package com.projet.GestionCabinet.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.GestionCabinet.DAO.ConsultationRepository;
import com.projet.GestionCabinet.Entities.Consultation;

@Service
public class ConsultationServiceImpl implements ConsultationService {

    @Autowired
    private ConsultationRepository consRep;

    @Override
    public List<Consultation> getAllConsultations() {
        return consRep.findAll();

    }

    @Override
    public Consultation findById(Long id) {
        return consRep.findById(id).get();
    }

    @Override
    public Consultation update(Long id, Consultation Consultation) {
        Consultation consult = consRep.findById(id).get();
        if (consult != null) {
            consult.setDate_consultation(Consultation.getDate_consultation());
            consult.setMotif(Consultation.getMotif());
            consult.setDiagnostique(Consultation.getDiagnostique());
            consult.setResExamClinique(Consultation.getResExamClinique());
            consult.setPoids(Consultation.getPoids());
            consult.setTaille(Consultation.getTaille());
            consult.setImc(Consultation.getImc());
            consult.setTemperature(Consultation.getTemperature());
            consult.setFreqCardiaque(Consultation.getFreqCardiaque());
            consult.setPressionArterielle(Consultation.getPressionArterielle());
            consult.setObservation(Consultation.getObservation());
            if (consult.getPatient() != null) {
                consult.setPatient(consult.getPatient());
            }
            return consRep.save(consult);
        } else
            return null;

    }

    @Override
    public Consultation add(Consultation Consultation) {
        return consRep.save(Consultation);
    }

    @Override
    public void delete(Long id) {
        consRep.deleteById(id);
    }

    @Override
    public List<Consultation> getConsultationsByPatientId(Long id) {
        return consRep.getConsultationsByPatientId(id);
    }

}

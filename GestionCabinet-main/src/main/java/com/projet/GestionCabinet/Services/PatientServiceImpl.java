package com.projet.GestionCabinet.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.GestionCabinet.DAO.PatientRepository;
import com.projet.GestionCabinet.Entities.Patient;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository patientRep;

    @Override
    public List<Patient> getAllPatients() {
        return patientRep.findAll();
    }

    @Override
    public Patient findPatientById(Long id) {
        return patientRep.findById(id).get();
    }

    @Override
    public Patient updatePatient(Long id, Patient patient) {
        Patient upPatient = patientRep.findById(id).get();
        if(upPatient != null){
        upPatient.setNomPatient(patient.getNomPatient());
        upPatient.setPrenomPatient(patient.getPrenomPatient());
        upPatient.setDateNaissance(patient.getDateNaissance());
        upPatient.setSexe(patient.getSexe());
        upPatient.setAdresse(patient.getAdresse());
        upPatient.setSituationFamilliale(patient.getSituationFamilliale());
        upPatient.setAssusranceMedical(patient.getAssusranceMedical());
        upPatient.setCodeAssurance(patient.getCodeAssurance());
        upPatient.setTelephone(patient.getTelephone());
        return patientRep.save(upPatient);
        } else return null;
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRep.save(patient);
    }

    @Override
    public void deletePatient(Long id) {
        patientRep.deleteById(id);
    }
    
}

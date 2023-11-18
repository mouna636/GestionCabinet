package com.projet.GestionCabinet.Services;
import java.util.List;
import com.projet.GestionCabinet.Entities.Patient;

public interface PatientService {
    
    public List<Patient> getAllPatients();

    public Patient findPatientById(Long id);

    public Patient updatePatient(Long id, Patient patient);

    public Patient addPatient(Patient patient);

    public void deletePatient(Long id);
}




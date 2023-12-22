package com.projet.GestionCabinet.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomPatient;
    private String prenomPatient;
    private String dateNaissance;
    private String sexe;
    private String adresse;
    private String situationFamilliale;
    private String assusranceMedical;
    private String codeAssurance;
    private String telephone;

    //ajout
    @OneToMany(mappedBy = "patient")
    private List<OrdonnancetTraitement> ordonnances;
}

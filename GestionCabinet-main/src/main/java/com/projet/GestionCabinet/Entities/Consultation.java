package com.projet.GestionCabinet.Entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Consultation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date_consultation;
    // private Date debut_consultation;
    // private Date fin_consultation; 
    private String motif;
    private String diagnostique;
    private String resExamClinique;
    private String poids;
    private String taille;
    private String imc;
    private String temperature;
    private String freqCardiaque;
    private String pressionArterielle;
    private String observation;


    @ManyToOne
    private Patient patient;

}

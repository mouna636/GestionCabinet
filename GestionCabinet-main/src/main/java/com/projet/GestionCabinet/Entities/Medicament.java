package com.projet.GestionCabinet.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Medicament {
    @Id
    @GeneratedValue()
    private Long id;
    private String nom;
    private String psologie;
    private Integer nbrUnite;
    private Integer qsp;

    @ManyToOne
    private OrdonnancetTraitement ordonnancetTraitement;
    
}
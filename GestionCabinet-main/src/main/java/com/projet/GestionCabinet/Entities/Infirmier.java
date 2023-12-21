package com.projet.GestionCabinet.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Infirmier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    private String telephone;
    /* private Date Naissance; */
    @Column
    private String sexe;
    @Column
    private String cin;
    @Column
    private String adresse;
    @Column
    private String email;
    @Column
    private String diplome;

}
package com.projet.GestionCabinet.Entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Infirmier {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private String nom;
   private String prenom;
   private String telephone;
   private Date Naissance; //
   private String sexe;
   private String cin;
   private String adresse;
   private String email;
   private String diplome;
   private Date dateEmbauche; //
   private double salaire; //
    
}
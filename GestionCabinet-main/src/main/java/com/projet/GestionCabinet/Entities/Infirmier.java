package com.projet.GestionCabinet.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
@Entity
public class Infirmier {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private String nom;
   private String prenom;
   private  String telephone; 
}
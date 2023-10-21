package com.projet.GestionCabinet.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Cabinet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String nom_cabinet;
    @Column
    private String localisation;

    public Cabinet(Long id, String nom_cabinet, String localisation) {
        this.id = id;
        this.nom_cabinet = nom_cabinet;
        this.localisation = localisation;
    }

}

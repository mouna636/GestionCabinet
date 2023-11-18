package com.projet.GestionCabinet.Entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class HoraireTravail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String heureDebut;
    private String heureFin;
    private String jourSemaine;

    public HoraireTravail(Date date, String heureDebut, String heureFin, String jourSemaine) {
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.jourSemaine = jourSemaine;
    }

}

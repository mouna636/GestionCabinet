package com.projet.GestionCabinet.DTO;

import java.util.List;
import com.projet.GestionCabinet.Entities.HoraireTravail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CabinetForm {

    private String name;

    private String adresse;

    private String specialite;

    private String telephone;

    private String matriculefiscale;

    private String image;

    private String ville;
    private List<HoraireTravail> horaires;
}

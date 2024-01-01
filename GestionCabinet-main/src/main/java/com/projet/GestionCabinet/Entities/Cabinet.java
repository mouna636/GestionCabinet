package com.projet.GestionCabinet.Entities;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projet.GestionCabinet.DTO.CabinetForm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Cabinet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String adresse;
    @Column
    private String specialite;
    @Column
    private String telephone;
    @Column
    private String matriculefiscale;
    @Column
    private String ville;
    @Column(length = 10485760) // Exemple : 10 Mo (10 * 1024 * 1024)
    @Lob
    private byte[] image;

    /*
     * @OneToOne(cascade = CascadeType.MERGE)
     * 
     * @JoinColumn(name = "user_id", referencedColumnName = "id")
     * private User user;
     */
    @JsonIgnore
    @OneToMany(mappedBy = "cabinet")
    private List<HoraireTravail> horaires;

    @JsonIgnore
    public CabinetForm getCabinet() {
        CabinetForm cabinetForm = new CabinetForm();
        cabinetForm.setId(id);
        cabinetForm.setAdresse(adresse);
        cabinetForm.setHoraires(horaires);
        cabinetForm.setName(name);
        cabinetForm.setSpecialite(specialite);
        cabinetForm.setTelephone(telephone);
        cabinetForm.setMatriculefiscale(matriculefiscale);
        cabinetForm.setVille(ville);
        cabinetForm.setReturnedImage(image);
        return cabinetForm;

    }

}

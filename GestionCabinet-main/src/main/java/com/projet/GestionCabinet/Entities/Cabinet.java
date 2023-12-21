package com.projet.GestionCabinet.Entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
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
    /*
     * @Column
     * private String image;
     */
    @Column
    private String ville;

    /*
     * @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
     * 
     * @JoinTable(name = "cabinetImages", joinColumns = { @JoinColumn(name =
     * "cabinet_id") }, inverseJoinColumns = {
     * 
     * @JoinColumn(name = "image_id") })
     * private Set<ImageModel> cabinetImages;
     */
    @JsonIgnore
    @OneToMany(mappedBy = "cabinet")
    private List<HoraireTravail> horaires;

    /*
     * @OneToMany(mappedBy = "cabinet", cascade = CascadeType.ALL, fetch =
     * FetchType.LAZY)
     * private List<User> users;
     */
}

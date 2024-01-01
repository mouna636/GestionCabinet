package com.projet.GestionCabinet.DTO;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.projet.GestionCabinet.Entities.HoraireTravail;
import com.projet.GestionCabinet.Entities.User;
import com.projet.GestionCabinet.ennums.CabinetStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CabinetForm {
    private Long id;
    private String name;

    private String adresse;

    private String specialite;

    private String telephone;

    private String matriculefiscale;

    private String ville;
    private List<HoraireTravail> horaires;
    private User user;
    private CabinetStatus cabinetStatus;

    private MultipartFile image;
    private byte[] returnedImage;
}

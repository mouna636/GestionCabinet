package com.projet.GestionCabinet.DTO;

import com.projet.GestionCabinet.ennums.UserRole;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private UserRole userRole;

}

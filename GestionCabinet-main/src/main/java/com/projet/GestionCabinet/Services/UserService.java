package com.projet.GestionCabinet.Services;

import com.projet.GestionCabinet.DTO.SignupDTO;
import com.projet.GestionCabinet.DTO.UserDTO;

public interface UserService {
    public UserDTO createUser(SignupDTO signupDTO);
}

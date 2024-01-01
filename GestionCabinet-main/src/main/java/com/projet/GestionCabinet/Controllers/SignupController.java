package com.projet.GestionCabinet.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.GestionCabinet.DTO.SignupDTO;
import com.projet.GestionCabinet.DTO.UserDTO;
import com.projet.GestionCabinet.Services.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SignupController {
    @Autowired
    private UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signupUser(@RequestBody SignupDTO signupDTO) {
        UserDTO createdUser = userService.createUser(signupDTO);
        if (createdUser == null) {
            return new ResponseEntity<>("User not created come again later", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

}

package com.projet.GestionCabinet.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projet.GestionCabinet.DAO.CabinetRepository;
import com.projet.GestionCabinet.DAO.UserRepository;
import com.projet.GestionCabinet.DTO.SignupDTO;
import com.projet.GestionCabinet.DTO.UserDTO;
import com.projet.GestionCabinet.Entities.Cabinet;
import com.projet.GestionCabinet.Entities.User;
import com.projet.GestionCabinet.ennums.CabinetStatus;
import com.projet.GestionCabinet.ennums.UserRole;

import jakarta.annotation.PostConstruct;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @PostConstruct
    public void createAdminAccount() {
        User adminAccount = userRepository.findByUserRole(UserRole.SupAdmin);
        if (adminAccount == null) {
            User user = new User();
            user.setUserRole(UserRole.SupAdmin);
            user.setEmail("admin@gmail.com");
            user.setName("Supadmin");
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(user);
        }

    }

    @Override
    public UserDTO createUser(SignupDTO signupDTO) {
        User user = new User();
        user.setName(signupDTO.getName());
        user.setEmail(signupDTO.getEmail());

        user.setUserRole(UserRole.ADMIN);

        user.setPassword(new BCryptPasswordEncoder().encode(signupDTO.getPassword()));

        User createdUser = userRepository.save(user);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(createdUser.getId());
        userDTO.setEmail(createdUser.getEmail());
        userDTO.setName(createdUser.getName());
        userDTO.setPassword(createdUser.getPassword());
        userDTO.setUserRole(createdUser.getUserRole());
        return userDTO;

    }
}

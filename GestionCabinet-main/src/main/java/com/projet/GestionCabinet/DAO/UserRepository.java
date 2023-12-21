package com.projet.GestionCabinet.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.GestionCabinet.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);

}

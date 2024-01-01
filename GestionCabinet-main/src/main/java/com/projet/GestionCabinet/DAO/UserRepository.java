package com.projet.GestionCabinet.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.GestionCabinet.Entities.User;
import com.projet.GestionCabinet.ennums.UserRole;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);

	User findByUserRole(UserRole userRole);
}

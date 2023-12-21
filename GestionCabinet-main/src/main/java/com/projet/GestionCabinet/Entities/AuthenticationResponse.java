package com.projet.GestionCabinet.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Data
@Builder
public class AuthenticationResponse {

	private final String token;
	private Role role;
}

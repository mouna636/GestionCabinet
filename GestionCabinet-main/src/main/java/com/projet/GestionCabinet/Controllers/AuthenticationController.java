package com.projet.GestionCabinet.Controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONException;
import org.json.JSONObject;

import com.projet.GestionCabinet.Config.SecurityConstant;
import com.projet.GestionCabinet.DAO.UserRepository;
import com.projet.GestionCabinet.DTO.AuthenticationRequest;

import com.projet.GestionCabinet.Entities.User;
import com.projet.GestionCabinet.Services.JwtService;
import com.projet.GestionCabinet.Services.UserDetailsService;
import com.projet.GestionCabinet.Services.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AuthenticationController {
    @Autowired
    UserService userService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtService jwtService;

    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

    @PostMapping("/auth")
    public void createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest,
            HttpServletResponse response)
            throws IOException, DisabledException, UsernameNotFoundException, BadCredentialsException, JSONException,
            ServletException {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("incorrect username or password");
        } catch (DisabledException disabledException) {
            response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "user not activated");

        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        User user = userRepository.findByEmail(userDetails.getUsername());
        final String jwt = jwtService.generateToken(authenticationRequest.getUsername());

        response.getWriter().write(new JSONObject()
                .put("userId", user.getId())
                .put("role", user.getUserRole())
                .toString());

        response.addHeader("Access-Control-Expose-Headers", "Authorization");
        response.addHeader("Access-Control-Allow-Headers", "Authorization");
        response.addHeader(HEADER_STRING, TOKEN_PREFIX + jwt);

    }
}

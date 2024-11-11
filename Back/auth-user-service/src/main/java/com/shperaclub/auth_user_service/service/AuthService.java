package com.shperaclub.auth_user_service.service;


import com.shperaclub.auth_user_service.config.JwtUtil;
import com.shperaclub.auth_user_service.repository.UserRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    public String authenticateUser(@NotNull String username, @NotNull String password) {
        // Autentica al usuario con las credenciales proporcionadas
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        //Establece el contexto de la seguridad actual
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //genera y devuelve el token
        return jwtUtil.generateToken(username);
    }

    public boolean userExists(String username) {

        //Veridicar si el usuario existe en la base
        return userRepository.existsByUsername(username);

    }
}

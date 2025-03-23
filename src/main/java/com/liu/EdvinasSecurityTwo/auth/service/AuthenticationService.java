package com.liu.EdvinasSecurityTwo.auth.service;

import com.liu.EdvinasSecurityTwo.auth.dto.AuthenticationRequest;
import com.liu.EdvinasSecurityTwo.auth.dto.AuthenticationResponse;
import com.liu.EdvinasSecurityTwo.auth.dto.RegisterRequest;
import com.liu.EdvinasSecurityTwo.auth.enums.Role;
import com.liu.EdvinasSecurityTwo.auth.model.User;
import com.liu.EdvinasSecurityTwo.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;

    public AuthenticationResponse register(RegisterRequest request) {

        var user = User.builder()
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.USER)
                .build();

        repository.save(user);
        var jwtToken = jwtService.generateToken(user);

        return new AuthenticationResponse(jwtToken);

    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );

        var user = repository.findByUsername(request.username())
                .orElseThrow(()-> new UsernameNotFoundException("Username not found " + request.username() ));

        var jwtToken = jwtService.generateToken(user);

        return new AuthenticationResponse(jwtToken);

    }
}

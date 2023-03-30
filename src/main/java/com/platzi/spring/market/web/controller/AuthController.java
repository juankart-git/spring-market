package com.platzi.spring.market.web.controller;

import com.platzi.spring.market.domain.dto.security.AuthenticationRequest;
import com.platzi.spring.market.domain.dto.security.AuthenticationResponse;
import com.platzi.spring.market.domain.service.ApiUserDetailServices;
import com.platzi.spring.market.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private ApiUserDetailServices services;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request){
        try {
            manager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            UserDetails userDetails = services.loadUserByUsername(request.getUsername());
            String jwt = jwtUtil.generateToken(userDetails);
            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
        } catch (BadCredentialsException ex){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

    }
}

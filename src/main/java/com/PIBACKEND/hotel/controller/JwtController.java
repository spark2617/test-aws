package com.PIBACKEND.hotel.controller;

import com.PIBACKEND.hotel.jwt.AuthenticationRequest;
import com.PIBACKEND.hotel.jwt.JwtUtil;


import com.PIBACKEND.hotel.model.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

@RestController
public class JwtController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        System.out.println("====authenticationRequest.getEmail()");
        System.out.println(authenticationRequest.getEmail());
        System.out.println("====authenticationRequest.getSenha()");
        System.out.println(authenticationRequest.getCollaborator_password());

        try {
            authenticationManager.authenticate(new
                    UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
                    authenticationRequest.getCollaborator_password()));

        } catch (BadCredentialsException e) {
            System.out.println("entrou no catch!");
            e.printStackTrace();
            throw new Exception("Incorrect", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
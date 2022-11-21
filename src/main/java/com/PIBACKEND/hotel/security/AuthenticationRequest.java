package com.PIBACKEND.hotel.security;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
public class AuthenticationRequest {

    private String email;
    private String collaborator_password;

}

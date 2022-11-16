package com.PIBACKEND.hotel.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table
public class Collaborator implements Serializable, UserDetails {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer collaborator_id;
    private String collaborator_name;
    private String collaborator_surname;
    private String email;
    private String collaborator_password;

    public Collaborator(){}

    public Collaborator(Integer collaborator_id, String collaborator_name,
                        String collaborator_surname, String email, String collaborator_password) {
        this.collaborator_id = collaborator_id;
        this.collaborator_name = collaborator_name;
        this.collaborator_surname = collaborator_surname;
        this.email = email;
        this.collaborator_password = collaborator_password;
    }

    //get e set


    public Integer getCollaborator_id() {
        return collaborator_id;
    }

    public void setCollaborator_id(Integer collaborator_id) {
        this.collaborator_id = collaborator_id;
    }

    public String getCollaborator_name() {
        return collaborator_name;
    }

    public void setCollaborator_name(String collaborator_name) {
        this.collaborator_name = collaborator_name;
    }

    public String getCollaborator_surname() {
        return collaborator_surname;
    }

    public void setCollaborator_surname(String collaborator_surname) {
        this.collaborator_surname = collaborator_surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCollaborator_password() {
        return collaborator_password;
    }

    public void setCollaborator_password(String collaborator_password) {
        this.collaborator_password = collaborator_password;
    }


    //metodos da interface UserDetails
    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.collaborator_password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

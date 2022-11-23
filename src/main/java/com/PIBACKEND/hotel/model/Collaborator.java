package com.PIBACKEND.hotel.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Collaborator implements Serializable, UserDetails {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer collaborator_id;
    @Column(nullable = false)
    private String collaborator_name;
    @Column(nullable = false)
    private String collaborator_surname;
    @Column(nullable = false, unique = true)
    private String email;
    private String collaborator_password;

    @ManyToOne
    @JsonIgnoreProperties
    private Acess acess_id;

    @OneToMany(mappedBy = "collaborator_id")
    private Set<Reservation> reservations=new HashSet<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Acess> acess=Collections.singletonList(this.acess_id);
        return acess;
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

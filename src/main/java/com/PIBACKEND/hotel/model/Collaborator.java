package com.PIBACKEND.hotel.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Collaborator implements Serializable{
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

//    @OneToMany
//    private Set<Reservation> reservations=new HashSet<>();

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private OffsetDateTime criado;
    @Column(columnDefinition = "TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private OffsetDateTime atualizado;


    @PrePersist
    public void antesDeSalvar() {
        criado = OffsetDateTime.now();
    }

    @PreUpdate
    public void antesDeAtualizar() {
        atualizado = OffsetDateTime.now();
    }

}

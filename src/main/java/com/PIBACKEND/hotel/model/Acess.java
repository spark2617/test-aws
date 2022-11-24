package com.PIBACKEND.hotel.model;

import com.PIBACKEND.hotel.dtos.AcessDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class Acess implements Serializable,GrantedAuthority{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer acess_id;
    private String acess_level;

    @OneToMany(mappedBy = "acess_id")
    private Set<Collaborator> collaborator_id=new HashSet<>();

    public Acess(){}

    public Acess(Integer acess_id, String acess_level) {
        this.acess_id = acess_id;
        this.acess_level = acess_level;
    }

    @Override
    public String getAuthority() {
        return this.acess_level;
    }
}

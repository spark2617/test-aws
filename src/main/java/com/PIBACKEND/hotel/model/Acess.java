package com.PIBACKEND.hotel.model;

import com.PIBACKEND.hotel.dtos.AcessDto;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Acess implements Serializable,GrantedAuthority{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer acess_id;
    private String acess_level;
    @OneToMany(mappedBy = "acess_id")
    private Set<Collaborator> collaboratorList=new HashSet<>();

    public Acess(){}

    public Acess(Integer acess_id, String acess_level) {
        this.acess_id = acess_id;
        this.acess_level = acess_level;
    }

    //get e set

    public Integer getAcess_id() {
        return acess_id;
    }

    public void setAcess_id(Integer acess_id) {
        this.acess_id = acess_id;
    }

    public String getAcess_level() {
        return acess_level;
    }

    public void setAcess_level(String acess_level) {
        this.acess_level = acess_level;
    }

    //OneToMany


    public Set<Collaborator> getCollaboratorList() {
        return collaboratorList;
    }

    public void setCollaboratorList(Set<Collaborator> collaboratorList) {
        this.collaboratorList = collaboratorList;
    }


    @Override
    public String getAuthority() {
        return this.acess_level;
    }
}

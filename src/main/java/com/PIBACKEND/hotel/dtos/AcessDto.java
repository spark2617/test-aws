package com.PIBACKEND.hotel.dtos;

import com.PIBACKEND.hotel.model.Acess;

import java.io.Serial;
import java.util.HashSet;
import java.util.Set;

public class AcessDto {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer acess_id;
    private String acess_level;

    private Set<CollaboratorDto> collaboratorList=new HashSet<>();

    public AcessDto(){}

    public AcessDto(Integer acess_id, String acess_level) {
        this.acess_id = acess_id;
        this.acess_level = acess_level;
    }
    //construtor dto
    public AcessDto(Acess model){
        this.acess_id=model.getAcess_id();
        this.acess_level=model.getAcess_level();

        //OneToMany
        model.getCollaboratorList().forEach(end->this.collaboratorList.add(new CollaboratorDto(end)));
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

    //relaconamento OneToMany
    public Set<CollaboratorDto> getCollaboratorList() {
        return collaboratorList;
    }

    public void setCollaboratorList(Set<CollaboratorDto> collaboratorList) {
        this.collaboratorList = collaboratorList;
    }
}

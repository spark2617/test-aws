package com.PIBACKEND.hotel.dtos;

import com.PIBACKEND.hotel.model.Acess;
import com.PIBACKEND.hotel.model.Collaborator;

import java.io.Serial;
import java.io.Serializable;

public class CollaboratorDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer collaborator_id;
    private String collaborator_name;
    private String collaborator_surname;
    private String email;

    //ManyToOne
    private AcessDto acess_id;

    public CollaboratorDto(){}

    public CollaboratorDto(Integer collaborator_id, String collaborator_name, String collaborator_surname, String email) {
        this.collaborator_id = collaborator_id;
        this.collaborator_name = collaborator_name;
        this.collaborator_surname = collaborator_surname;
        this.email = email;
    }

    public CollaboratorDto(Collaborator model){
        this.collaborator_id=model.getCollaborator_id();
        this.collaborator_name=model.getCollaborator_name();
        this.collaborator_surname=model.getCollaborator_surname();
        this.email=model.getEmail();

        this.acess_id=new AcessDto(model.getAcess());
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



    //relacionamento ManYToOne
    public AcessDto getAcess_id() {
        return acess_id;
    }

    public void setAcess_id(AcessDto acess_id) {
        this.acess_id = acess_id;
    }

}

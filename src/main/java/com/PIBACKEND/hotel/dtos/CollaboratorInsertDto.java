package com.PIBACKEND.hotel.dtos;

import com.PIBACKEND.hotel.model.Collaborator;

public class CollaboratorInsertDto extends CollaboratorDto{
    private static final long serialVersionUID = 1L;

    private String collaborator_password;

    public CollaboratorInsertDto(){
        super();
    }
    public CollaboratorInsertDto(Collaborator model){
        super();
    }

    //get e set

    public String getCollaborator_password() {
        return collaborator_password;
    }

    public void setCollaborator_password(String collaborator_password) {
        this.collaborator_password = collaborator_password;
    }
}

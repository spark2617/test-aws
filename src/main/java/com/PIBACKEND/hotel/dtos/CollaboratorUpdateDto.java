package com.PIBACKEND.hotel.dtos;

import com.PIBACKEND.hotel.model.Collaborator;

public class CollaboratorUpdateDto extends CollaboratorDto{
    private static final long serialVersionUID = 1L;
    public CollaboratorUpdateDto(){

    }
    public CollaboratorUpdateDto(Collaborator user){
        super(user);
    }

}

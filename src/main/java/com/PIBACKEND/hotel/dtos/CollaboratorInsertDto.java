package com.PIBACKEND.hotel.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CollaboratorInsertDto extends CollaboratorDto{
    private static final long serialVersionUID = 1L;
    private String Collaborator_password;

    public CollaboratorInsertDto(){
        super();
    }

}

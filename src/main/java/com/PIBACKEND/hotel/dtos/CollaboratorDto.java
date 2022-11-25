package com.PIBACKEND.hotel.dtos;

import com.PIBACKEND.hotel.model.Acess;
import com.PIBACKEND.hotel.model.Collaborator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToOne;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CollaboratorDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer collaborator_id;
    private String collaborator_name;
    private String collaborator_surname;
    private String email;
    private String collaborator_password;

    //ManyToOne
    private int acess_id;

    //OneToMany
    private Set<ReservationDto> reservation= new HashSet<>();


    public CollaboratorDto(Integer collaborator_id, String collaborator_name, String collaborator_surname, String email, String collaborator_password) {
        this.collaborator_id = collaborator_id;
        this.collaborator_name = collaborator_name;
        this.collaborator_surname = collaborator_surname;
        this.email = email;
        this.collaborator_password = collaborator_password;
        //this.acess_id = acess_id;
    }

    public CollaboratorDto(Collaborator model){
        this.collaborator_id=model.getCollaborator_id();
        this.collaborator_name=model.getCollaborator_name();
        this.collaborator_surname=model.getCollaborator_surname();
        this.email=model.getEmail();
        this.collaborator_password=model.getCollaborator_password();


        this.acess_id=model.getAcess_id().getAcess_id();
//        this.acess_id=new AcessDto(model.getAcess_id());
        model.getReservations().forEach(end->this.reservation.add(new ReservationDto(end)));
    }




}

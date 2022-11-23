package com.PIBACKEND.hotel.dtos;

import com.PIBACKEND.hotel.model.Reservation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ReservationDto {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer reservation_id;
    private String checkin_date;
    private String checkout_date;
    private String checkin_hour;
    private String checkout_hour;
    private ProductDto product_id;

    private CollaboratorDto collaborator_id;


    public ReservationDto(Integer reservation_id, String checkin_date, String checkout_date, String checkin_hour,
                          String checkout_hour, ProductDto product_id, CollaboratorDto collaborator_id) {
        this.reservation_id = reservation_id;
        this.checkin_date = checkin_date;
        this.checkout_date = checkout_date;
        this.checkin_hour = checkin_hour;
        this.checkout_hour = checkout_hour;
        this.product_id = product_id;
        this.collaborator_id = collaborator_id;
    }

    public ReservationDto(Reservation model){
        this.reservation_id=model.getReservation_id();
        this.checkin_hour=model.getCheckin_hour();
        this.checkout_hour=model.getCheckout_hour();
        this.checkin_date=model.getCheckin_date();
        this.checkout_date=model.getCheckout_date();

        this.product_id=new ProductDto(model.getProduct_id());

        this.collaborator_id=new CollaboratorDto(model.getCollaborator_id());

    }
}

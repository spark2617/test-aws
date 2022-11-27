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
    private Date checkin_date;
    private Date checkout_date;
    private String checkin_time;
    private String checkout_time;
    private int product_id;
    private int collaborator_id;


    public ReservationDto(Integer reservation_id, Date checkin_date, Date checkout_date, String checkin_hour,
                          String checkout_hour) {
        this.reservation_id = reservation_id;
        this.checkin_date = checkin_date;
        this.checkout_date = checkout_date;
        this.checkin_time = checkin_hour;
        this.checkout_time = checkout_hour;


    }

    public ReservationDto(Reservation model){
        this.reservation_id=model.getReservation_id();
        this.checkin_time=model.getCheckin_time();
        this.checkout_time=model.getCheckout_time();
        this.checkin_date=model.getCheckin_date();
        this.checkout_date=model.getCheckout_date();

        this.product_id=model.getProduct_id().getProduct_id();
        this.collaborator_id=model.getCollaborator_id().getCollaborator_id();



    }
}

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
    private Date checkin_date=new Date();
    private Date checkout_date=new Date();
    private Date checkin_hour=new Date();
    private Date checkout_hour=new Date();
    private ProductDto product_id;


    public ReservationDto(Integer reservation_id, Date checkin_date,
                          Date checkout_date, Date checkin_hour, Date checkout_hour) {
        this.reservation_id = reservation_id;
        this.checkin_date = checkin_date;
        this.checkout_date = checkout_date;
        this.checkin_hour = checkin_hour;
        this.checkout_hour = checkout_hour;
    }

    public ReservationDto(Reservation model){
        this.reservation_id=model.getReservation_id();
        this.checkin_hour=model.getCheckin_hour();
        this.checkout_hour=model.getCheckout_hour();
        this.checkin_date=model.getCheckin_date();
        this.checkout_date=model.getCheckout_date();

        this.product_id=new ProductDto(model.getProduct_id());
    }
}

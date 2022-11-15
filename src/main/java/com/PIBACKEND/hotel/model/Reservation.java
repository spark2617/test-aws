package com.PIBACKEND.hotel.model;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table
public class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id//chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)//chave estrangeira
    private Integer reservation_id;
    private LocalDate checkin_date;
    private LocalDate checkout_date;

    public Reservation(){}

    public Reservation(Integer reservation_id, LocalDate checkin_date, LocalDate checkout_date) {
        this.reservation_id = reservation_id;
        this.checkin_date = checkin_date;
        this.checkout_date = checkout_date;
    }

    //get e set


    public Integer getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(Integer reservation_id) {
        this.reservation_id = reservation_id;
    }

    public LocalDate getCheckin_date() {
        return checkin_date;
    }

    public void setCheckin_date(LocalDate checkin_date) {
        this.checkin_date = checkin_date;
    }

    public LocalDate getCheckout_date() {
        return checkout_date;
    }

    public void setCheckout_date(LocalDate checkout_date) {
        this.checkout_date = checkout_date;
    }
}

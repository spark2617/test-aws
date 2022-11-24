package com.PIBACKEND.hotel.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id//chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)//chave estrangeira
    private Integer reservation_id;

    @Column(name = "checkin_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date checkin_date;

    @Column(name = "checkin_time")
    private String checkin_time;

    @Column(name = "checkout_date")
    private Date checkout_date;

    @Column(name = "checkout_time")
    @DateTimeFormat(pattern = "HH:mm")
    private String checkout_time;


    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product_id;

    @ManyToOne
    @JoinColumn(name="collaborator_id")
    private Collaborator collaborator_id;




}

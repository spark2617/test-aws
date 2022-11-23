package com.PIBACKEND.hotel.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id//chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)//chave estrangeira
    private Integer reservation_id;
    private String checkin_date;
    private String checkout_date;
    private String checkin_hour;
    private String checkout_hour;


    @ManyToOne
    private Product product_id;

    @ManyToOne
    private Collaborator collaborator_id;




}

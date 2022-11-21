package com.PIBACKEND.hotel.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
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
    private Date checkin_date=new Date();
    private Date checkout_date=new Date();
    private Date checkin_hour=new Date();
    private Date checkout_hour=new Date();


    @ManyToOne
    private Product product_id;


    // Timestamps Automáticos
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private OffsetDateTime criado;
    @Column(columnDefinition = "TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private OffsetDateTime atualizado;

    @PrePersist
    public void antesDeSalvar() {
        criado = OffsetDateTime.now();
    }

    @PreUpdate
    public void antesDeAtualizar() {
        atualizado = OffsetDateTime.now();
    }


}

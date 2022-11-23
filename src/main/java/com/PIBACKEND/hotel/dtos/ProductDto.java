package com.PIBACKEND.hotel.dtos;

import com.PIBACKEND.hotel.model.Product;
import com.PIBACKEND.hotel.model.Reservation;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Getter
@Setter
public class ProductDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer product_id;
    private String product_name;
    private String product_description;

    private Set<FeatureDto> features =new HashSet<>();


    private String category;

    private Set<ImageDto> images=new HashSet<>();

    private ZoneDto zone;

    //private Set<ReservationDto> reservations =new HashSet<>();
    public ProductDto(){}

    public ProductDto(Integer product_id, String product_name, String product_description, ZoneDto zone) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.zone = zone;
    }

    //contrutor dto

    public ProductDto(Product model){

        this.product_id=model.getProduct_id();
        this.product_name=model.getProduct_name();
        this.product_description=model.getProduct_description();

        //OneToOne
        this.zone=new ZoneDto(model.getZone_id());

        //manyToOne
        this.category=model.getCategory_id().getCategory_name();


        //OneToMany
        model.getImages().forEach(end->this.images.add(new ImageDto(end)));


        //ManyToMany
        model.getFeatureList().forEach(end->this.features.add(new FeatureDto(end)));

        //OneToMany
       // model.getReservations().forEach(end->this.reservations.add(new ReservationDto(end)));

    }


}

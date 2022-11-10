package com.PIBACKEND.hotel.dtos;

import com.PIBACKEND.hotel.model.Zone;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class ZoneDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer zone_id;
    private double latitude;
    private double longitude;


    //ManyToOne
//    private MetaverseDto metaverseDto;
    private String metaverse_nome;


    //OneToOne
    private int product_id;



    public ZoneDto(){}

    public ZoneDto(Integer zone_id, double latitude, double longitude) {
        this.zone_id = zone_id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public ZoneDto(Zone model){
        this.zone_id=model.getZone_id();
        this.longitude=model.getLongitude();
        this.latitude=model.getLatitude();

        //ManyToOne
        this.metaverse_nome=model.getMetaverse_id().getMetaverse_name();

        //oneToOne


    }

    //get e set

    public Integer getZone_id() {
        return zone_id;
    }

    public void setZone_id(Integer zone_id) {
        this.zone_id = zone_id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

//OneToOne

//
//    public List<ProductDto> getProductDto() {
//        return productDto;
//    }
//
//    public void setProductDto(List<ProductDto> productDto) {
//        this.productDto = productDto;
//    }
}

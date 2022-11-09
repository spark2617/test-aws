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
    private MetaverseDto metaverseDto;


    //OneToOne
    private ProductDto productDto;



    public ZoneDto(){}

    public ZoneDto(Integer zone_id, double latitude, double longitude) {
        this.zone_id = zone_id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public ZoneDto(Zone model){

        this.longitude=model.getLongitude();
        this.latitude=model.getLatitude();

        //ManyToOne
        this.metaverseDto=new MetaverseDto(model.getMetaverse_id());

        //oneToOne
        this.productDto=new ProductDto(model.getProduct_id());

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

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }
}

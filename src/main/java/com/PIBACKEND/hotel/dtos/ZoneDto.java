package com.PIBACKEND.hotel.dtos;

import com.PIBACKEND.hotel.model.Zone;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class ZoneDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer zone_id;
    private String coordinate;


    //ManyToOne
    private MetaverseDto metaverseDto;


    //OneToOne
    private ProductDto productDto;



    public ZoneDto(){}

    public ZoneDto(Integer zone_id, String coordinate, String metaverse) {
        this.zone_id = zone_id;
        this.coordinate = coordinate;

    }

    public ZoneDto(Zone model){

        this.coordinate=model.getCoordinate();

        //ManyToOne
        this.metaverseDto=new MetaverseDto(model.getMetaverse_id());

        //oneToMany
        this.productDto=new ProductDto(model.getProduct());

    }

    //get e set

    public Integer getZone_id() {
        return zone_id;
    }

    public void setZone_id(Integer zone_id) {
        this.zone_id = zone_id;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }





    //OneToOne

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }
}

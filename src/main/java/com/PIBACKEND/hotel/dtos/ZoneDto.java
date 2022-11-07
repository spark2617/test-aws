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
    private String metaverse;


    private List<ProductDto> Products;

    public ZoneDto(){}

    public ZoneDto(Integer zone_id, String coordinate, String metaverse) {
        this.zone_id = zone_id;
        this.coordinate = coordinate;
        this.metaverse = metaverse;
    }

    public ZoneDto(Zone model){

        this.metaverse=model.getMetaverse();
        this.coordinate=model.getCoordinate();

        model.getLsProducts().forEach(end->this.Products.add(new ProductDto(end)));

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

    public String getMetaverse() {
        return metaverse;
    }

    public void setMetaverse(String metaverse) {
        this.metaverse = metaverse;
    }

////OneToMany


    public List<ProductDto> getProducts() {
        return Products;
    }

    public void setProducts(List<ProductDto> products) {
        Products = products;
    }
}

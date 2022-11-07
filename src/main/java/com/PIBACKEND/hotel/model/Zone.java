package com.PIBACKEND.hotel.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Zone implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id//chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)//chave estrangeira
    private Integer zone_id;
    private String coordinate;
    private String metaverse;

    //construtor

    public Zone(){}

    public Zone(Integer zone_id, String coordinate, String metaverse) {
        this.zone_id = zone_id;
        this.coordinate = coordinate;
        this.metaverse = metaverse;
    }

    //OneToMany
    @OneToMany(mappedBy = "city_id")
    private List<Product> lsProducts;




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


    //oneToMany


    public List<Product> getLsProducts() {
        return lsProducts;
    }

    public void setLsProducts(List<Product> lsProducts) {
        this.lsProducts = lsProducts;
    }
}

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

    private double latitude;
    private double longitude;


    //construtor

    public Zone(){}

    public Zone(Integer zone_id, double latitude, double longitude) {
        this.zone_id = zone_id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @OneToMany
    @JoinColumn(name="product_id")
    private List<Product> product_id;


    @ManyToOne
    @JoinColumn(name="metaverse_id")
    private Metaverse metaverse_id;


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

    public List<Product> getProduct_id() {
        return product_id;
    }

    public void setProduct_id(List<Product> product_id) {
        this.product_id = product_id;
    }


    //ManyToOne

    public Metaverse getMetaverse_id() {
        return metaverse_id;
    }

    public void setMetaverse_id(Metaverse metaverse_id) {
        this.metaverse_id = metaverse_id;
    }
}

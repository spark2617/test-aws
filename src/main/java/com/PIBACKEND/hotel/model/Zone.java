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
    private Integer zoneid;
    private double latitude;
    private double longitude;


    //construtor

    public Zone(){}

    public Zone(Integer zoneid, double latitude, double longitude) {
        this.zoneid = zoneid;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @OneToOne
    @JoinColumn(name="product_id")
    private Product product_id;


    @ManyToOne
    @JoinColumn(name="metaverse_id")
    private Metaverse metaverse_id;


    //get e set


    public Integer getZoneid() {
        return zoneid;
    }

    public void setZoneid(Integer zoneid) {
        this.zoneid = zoneid;
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

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
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

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
    @JoinColumn(name="productid")
    private Product productid;


    @ManyToOne
    @JoinColumn(name="metaverseid")
    private Metaverse metaverseid;


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

    public Product getProductid() {
        return productid;
    }

    public void setProductid(Product productid) {
        this.productid = productid;
    }


    //ManyToOne
    public Metaverse getMetaverseid() {
        return metaverseid;
    }

    public void setMetaverseid(Metaverse metaverseid) {
        this.metaverseid = metaverseid;
    }




}

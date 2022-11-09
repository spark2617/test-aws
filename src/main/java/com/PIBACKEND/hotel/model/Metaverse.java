package com.PIBACKEND.hotel.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
public class Metaverse implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id//chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)//chave estrangeira
    private Integer metaverse_id;
    private String metaverse_name;

    public Metaverse(){}

    public Metaverse(Integer metaverse_id, String metaverse_name) {
        this.metaverse_id = metaverse_id;
        this.metaverse_name = metaverse_name;
    }


    @OneToMany(mappedBy = "metaverse_id")
    private Set<Zone> zones;


    //get e set
    public Integer getMetaverse_id() {
        return metaverse_id;
    }

    public void setMetaverse_id(Integer metaverse_id) {
        this.metaverse_id = metaverse_id;
    }

    public String getMetaverse_name() {
        return metaverse_name;
    }

    public void setMetaverse_name(String metaverse_name) {
        this.metaverse_name = metaverse_name;
    }


    //OneToMany

    public Set<Zone> getZones() {
        return zones;
    }

    public void setZones(Set<Zone> zones) {
        this.zones = zones;
    }
}

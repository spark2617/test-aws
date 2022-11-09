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
    private Integer metaverseid;
    private String metaversename;

    public Metaverse(){}

    public Metaverse(Integer metaverseid, String metaversename) {
        this.metaverseid = metaverseid;
        this.metaversename = metaversename;
    }

    @OneToMany(mappedBy = "metaverseid")
    private Set<Zone> zones;


    //get e set

    public Integer getMetaverseid() {
        return metaverseid;
    }

    public void setMetaverseid(Integer metaverseid) {
        this.metaverseid = metaverseid;
    }

    public String getMetaversename() {
        return metaversename;
    }

    public void setMetaversename(String metaversename) {
        this.metaversename = metaversename;
    }


    //OneToMany

    public Set<Zone> getZones() {
        return zones;
    }

    public void setZones(Set<Zone> zones) {
        this.zones = zones;
    }
}

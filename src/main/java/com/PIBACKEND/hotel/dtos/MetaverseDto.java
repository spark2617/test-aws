package com.PIBACKEND.hotel.dtos;

import com.PIBACKEND.hotel.model.Metaverse;

import java.io.Serial;
import java.util.Set;

public class MetaverseDto {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer metaverse_id;
    private String metaverse_name;

    private Set<ZoneDto> zones;


    public MetaverseDto(){}

    public MetaverseDto(Integer metaverse_id, String metaverse_name) {
        this.metaverse_id = metaverse_id;
        this.metaverse_name = metaverse_name;
    }

    public MetaverseDto(Metaverse model){
        this.metaverse_id=model.getMetaverse_id();
        this.metaverse_name=model.getMetaverse_name();

       // model.getZones().forEach(end->this.zones.add(new ZoneDto(end)));


    }

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
    public Set<ZoneDto> getZones() {
        return zones;
    }

    public void setZones(Set<ZoneDto> zones) {
        this.zones = zones;
    }
}

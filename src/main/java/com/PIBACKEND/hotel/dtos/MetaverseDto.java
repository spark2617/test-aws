package com.PIBACKEND.hotel.dtos;

import com.PIBACKEND.hotel.model.Metaverse;

import java.io.Serial;
import java.util.Set;

public class MetaverseDto {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer metaverseid;
    private String metaversename;

    private Set<ZoneDto> zones;


    public MetaverseDto(){}

    public MetaverseDto(Integer metaverse_id, String metaverse_name) {
        this.metaverseid = metaverse_id;
        this.metaversename = metaverse_name;
    }

    public MetaverseDto(Metaverse model){
        this.metaverseid=model.getMetaverseid();
        this.metaversename=model.getMetaversename();

        model.getZones().forEach(end->this.zones.add(new ZoneDto(end)));


    }

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
    public Set<ZoneDto> getZones() {
        return zones;
    }

    public void setZones(Set<ZoneDto> zones) {
        this.zones = zones;
    }
}

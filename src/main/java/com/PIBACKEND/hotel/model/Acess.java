package com.PIBACKEND.hotel.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Acess implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer acess_id;
    private String acess_level;

    public Acess(){}

    public Acess(Integer acess_id, String acess_level) {
        this.acess_id = acess_id;
        this.acess_level = acess_level;
    }

    //get e set

    public Integer getAcess_id() {
        return acess_id;
    }

    public void setAcess_id(Integer acess_id) {
        this.acess_id = acess_id;
    }

    public String getAcess_level() {
        return acess_level;
    }

    public void setAcess_level(String acess_level) {
        this.acess_level = acess_level;
    }
}

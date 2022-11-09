package com.PIBACKEND.hotel.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Feature implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id//chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)//chave estrangeira
    private Integer featureid;
    private String featurename;
    private String icon;

    //contrutor

    public Feature(){}

    public Feature(Integer featureid, String featurename, String icon) {
        this.featureid = featureid;
        this.featurename = featurename;
        this.icon = icon;
    }

    //get e set


    public Integer getFeatureid() {
        return featureid;
    }

    public void setFeatureid(Integer featureid) {
        this.featureid = featureid;
    }

    public String getFeaturename() {
        return featurename;
    }

    public void setFeaturename(String featurename) {
        this.featurename = featurename;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}

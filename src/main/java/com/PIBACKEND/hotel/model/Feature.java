package com.PIBACKEND.hotel.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Feature implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id//chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)//chave estrangeira
    private Integer feature_id;
    private String feature_name;
    private String icon;

    //contrutor

    public Feature(){}

    public Feature(Integer features_id, String features_name, String icon) {
        this.feature_id = features_id;
        this.feature_name = features_name;
        this.icon = icon;
    }

    //get e set

    public Integer getFeature_id() {
        return feature_id;
    }

    public void setFeature_id(Integer feature_id) {
        this.feature_id = feature_id;
    }

    public String getFeature_name() {
        return feature_name;
    }

    public void setFeature_name(String feature_name) {
        this.feature_name = feature_name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}

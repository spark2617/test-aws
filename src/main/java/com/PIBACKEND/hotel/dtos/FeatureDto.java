package com.PIBACKEND.hotel.dtos;

import com.PIBACKEND.hotel.model.Feature;

import java.io.Serial;
import java.io.Serializable;

public class FeatureDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer feature_id;
    private String feature_name;
    private String icon;

    public FeatureDto(){}

    public FeatureDto(Integer features_id, String name, String icon) {
        this.feature_id = features_id;
        this.feature_name = name;
        this.icon = icon;
    }

    public FeatureDto(Feature model){
        this.feature_id =model.getFeature_id();
        this.feature_name =model.getFeature_name();
        this.icon=model.getIcon();
    }

    //get set
    public Integer getFeature_id() {
        return feature_id;
    }

    public void setFeature_id(Integer feature_id) {
        this.feature_id = feature_id;
    }

    public String getFeature_name() {
        return feature_name;
    }

    public void setFeature_name(String features_name) {
        this.feature_name = features_name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}

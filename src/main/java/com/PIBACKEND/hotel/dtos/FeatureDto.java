package com.PIBACKEND.hotel.dtos;

import com.PIBACKEND.hotel.model.Feature;

import java.io.Serial;
import java.io.Serializable;

public class FeatureDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer featureid;
    private String featurename;
    private String icon;

    public FeatureDto(){}

    public FeatureDto(Integer features_id, String name, String icon) {
        this.featureid = features_id;
        this.featurename = name;
        this.icon = icon;
    }

    public FeatureDto(Feature model){
        this.featureid =model.getFeatureid();
        this.featurename =model.getFeaturename();
        this.icon=model.getIcon();
    }

    //get set


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

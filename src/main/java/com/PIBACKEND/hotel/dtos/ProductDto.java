package com.PIBACKEND.hotel.dtos;

import com.PIBACKEND.hotel.model.Product;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ProductDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer product_id;
    private String product_name;
    private String product_description;

    private Set<FeatureDto> features =new HashSet<>();


//    private CategoryDto categorys;
    private String category;

    private Set<ImageDto> images=new HashSet<>();

    private ZoneDto zone;


    public ProductDto(){}

    public ProductDto(Integer product_id, String product_name, String product_description, ZoneDto zone) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.zone = zone;
    }

    //contrutor dto

    public ProductDto(Product model){

        this.product_id=model.getProduct_id();
        this.product_name=model.getProduct_name();
        this.product_description=model.getProduct_description();

        //OneToOne
        this.zone=new ZoneDto(model.getZone_id());
        //this.zone_id=model.getZone_id().getZone_id();

        //manyToOne
        this.category=model.getCategory_id().getCategory_name();


        //OneToMany
        model.getImages().forEach(end->this.images.add(new ImageDto(end)));


        //ManyToMany
        model.getFeatureList().forEach(end->this.features.add(new FeatureDto(end)));


    }

    //get e set
    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

//manyToMany

    public Set<FeatureDto> getFeatures() {
        return features;
    }

    public void setFeatures(Set<FeatureDto> features) {
        this.features = features;
    }


    //ManyToOne

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    //oneToMany


    public Set<ImageDto> getImages() {
        return images;
    }

    public void setImages(Set<ImageDto> images) {
        this.images = images;
    }


    //OneToOne

    public ZoneDto getZone() {
        return zone;
    }

    public void setZone(ZoneDto zone) {
        this.zone = zone;
    }

}

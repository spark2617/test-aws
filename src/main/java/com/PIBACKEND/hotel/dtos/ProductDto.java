package com.PIBACKEND.hotel.dtos;

import com.PIBACKEND.hotel.model.Category;
import com.PIBACKEND.hotel.model.City;
import com.PIBACKEND.hotel.model.Product;

import java.io.Serializable;
import java.io.Serial;
import java.util.HashSet;
import java.util.Set;

public class ProductDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer product_id;
    private String product_name;
    private String product_description;

    private Set<FeatureDto> featureDtoList =new HashSet<>();

    private Category category;
//
//    private City city;

    public ProductDto(){}

    public ProductDto(Integer product_id, String name, String description) {
        this.product_id = product_id;
        this.product_name = name;
        this.product_description = description;
    }

    //contrutor dto

    public ProductDto(Product model){

        this.product_id=model.getProduct_id();
        this.product_name=model.getProduct_name();
        this.product_description=model.getProduct_description();


//        //manyToOne
        //this.category=model.getCategory();
//        this.city=model.getCity();


        //ManyToMany
        model.getFeatureList().forEach(end->this.featureDtoList.add(new FeatureDto(end)));


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


    public Set<FeatureDto> getFeatureDtoList() {
        return featureDtoList;
    }

    public void setFeatureDtoList(Set<FeatureDto> featureDtoSet) {
        this.featureDtoList = featureDtoSet;
    }

    //ManyToOne


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

//
//    //ManyToOne
//    public City getCity() {
//        return city;
//    }
//
//    public void setCity(City city) {
//        this.city = city;
//    }
}

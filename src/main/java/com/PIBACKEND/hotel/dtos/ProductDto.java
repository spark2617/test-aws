package com.PIBACKEND.hotel.dtos;

import com.PIBACKEND.hotel.model.Category;
import com.PIBACKEND.hotel.model.Product;
import com.PIBACKEND.hotel.model.Zone;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ProductDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer product_id;
    private Zone zone_id;
    private Category category_id;
    private String product_name;
    private String product_description;

    private Set<FeatureDto> featureDtoList =new HashSet<>();

    private CategoryDto categoryDto;

    private Set<ImageDto> images=new HashSet<>();

    private ZoneDto zoneDto;

    public ProductDto(){}

    public ProductDto(Integer product_id, String product_name, String product_description, Category category_id, Zone zone_id) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.category_id = category_id;
        this.zone_id = zone_id;
    }

    //contrutor dto

    public ProductDto(Product model){

        this.product_id=model.getProduct_id();
        this.product_name=model.getProduct_name();
        this.product_description=model.getProduct_description();

        //OneToOne
        this.zoneDto=new ZoneDto(model.getZone_id());

        //manyToOne
        this.categoryDto =new CategoryDto(model.getCategory_id());


        //OneToMany
        model.getImages().forEach(end->this.images.add(new ImageDto(end)));



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

    public Zone getZone_id() {
        return zone_id;
    }

    public void setZone_id(Zone zone_id) {
        this.zone_id = zone_id;
    }

    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
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

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }



    //oneToMany


    public Set<ImageDto> getImages() {
        return images;
    }

    public void setImages(Set<ImageDto> images) {
        this.images = images;
    }


    //OneToOne


    public ZoneDto getZoneDto() {
        return zoneDto;
    }

    public void setZoneDto(ZoneDto zoneDto) {
        this.zoneDto = zoneDto;
    }
}

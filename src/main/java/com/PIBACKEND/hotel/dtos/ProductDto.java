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

    private Set<FeatureDto> featureDtoList =new HashSet<>();

    private CategoryDto categorys;

    private Set<ImageDto> images=new HashSet<>();

    private ZoneDto zoneDto;

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

        //OneToOne
        this.zoneDto=new ZoneDto(model.getZone_id());


        //manyToOne
        //this.categorys=new CategoryDto(model.getCategory_id());


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

    public CategoryDto getCategorys() {
        return categorys;
    }

    public void setCategorys(CategoryDto categorys) {
        this.categorys = categorys;
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

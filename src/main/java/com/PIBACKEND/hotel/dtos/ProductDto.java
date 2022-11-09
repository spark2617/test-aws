package com.PIBACKEND.hotel.dtos;

import com.PIBACKEND.hotel.model.Product;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ProductDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer productid;
    private String productname;
    private String productdescription;

    private Set<FeatureDto> featureDtoList =new HashSet<>();

    private CategoryDto categorys;

    private Set<ImageDto> images=new HashSet<>();

    private ZoneDto zoneDto;

    public ProductDto(){}

    public ProductDto(Integer product_id, String name, String description) {
        this.productid = product_id;
        this.productname = name;
        this.productdescription = description;
    }

    //contrutor dto

    public ProductDto(Product model){

        this.productid=model.getProductid();
        this.productname=model.getProductname();
        this.productdescription=model.getProductdescription();

        //OneToOne
        this.zoneDto=new ZoneDto(model.getZoneid());


        //manyToOne
        this.categorys=new CategoryDto(model.getCategoryid());


        //OneToMany
        model.getImages().forEach(end->this.images.add(new ImageDto(end)));



        //ManyToMany
        model.getFeatureList().forEach(end->this.featureDtoList.add(new FeatureDto(end)));


    }

    //get e set

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductdescription() {
        return productdescription;
    }

    public void setProductdescription(String productdescription) {
        this.productdescription = productdescription;
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

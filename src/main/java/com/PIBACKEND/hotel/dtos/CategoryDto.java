package com.PIBACKEND.hotel.dtos;

import com.PIBACKEND.hotel.model.Category;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

public class CategoryDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer category_id;
    private String category_name;
    private String category_description;
    private String url_image;

    private Set<ProductDto> Products;

    public CategoryDto() {
    }

    public CategoryDto(Integer category_id, String category_name, String category_description, String url_image) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.category_description = category_description;
        this.url_image = url_image;
    }

    public CategoryDto(Category category) {
        this.category_id = category.getCategory_id();
        this.category_name=category.getCategory_name();
        this.category_description = category.getCategory_description();
        this.url_image = category.getUrl_image();


        //oneToMany
        //category.getLsProduct().forEach(end->this.Products.add(new ProductDto(end)));
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_description() {
        return category_description;
    }

    public void setCategory_description(String category_description) {
        this.category_description = category_description;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

//oneToMany


    public Set<ProductDto> getLsProducts() {
        return Products;
    }

    public void setLsProducts(Set<ProductDto> lsProducts) {
        this.Products = lsProducts;
    }
}

package com.PIBACKEND.hotel.dtos;

import com.PIBACKEND.hotel.model.Category;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

public class CategoryDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer categoryid;
    private String categoryname;
    private String categorydescription;
    private String urlimage;

    private Set<ProductDto> Products;

    public CategoryDto() {
    }

    public CategoryDto(Integer category_id, String category_name, String category_description, String url_image) {
        this.categoryid = category_id;
        this.categoryname = category_name;
        this.categorydescription = category_description;
        this.urlimage = url_image;
    }

    public CategoryDto(Category category) {
        this.categoryid = category.getCategoryid();
        this.categoryname=category.getCategoryname();
        this.categorydescription = category.getCategorydescription();
        this.urlimage = category.getUrlimage();


        //oneToMany
        category.getLsProduct().forEach(end->this.Products.add(new ProductDto(end)));
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getCategorydescription() {
        return categorydescription;
    }

    public void setCategorydescription(String categorydescription) {
        this.categorydescription = categorydescription;
    }

    public String getUrlimage() {
        return urlimage;
    }

    public void setUrlimage(String urlimage) {
        this.urlimage = urlimage;
    }

    //oneToMany


    public Set<ProductDto> getLsProducts() {
        return Products;
    }

    public void setLsProducts(Set<ProductDto> lsProducts) {
        this.Products = lsProducts;
    }
}

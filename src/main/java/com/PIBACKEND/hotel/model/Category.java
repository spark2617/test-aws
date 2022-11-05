package com.PIBACKEND.hotel.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id//chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)//chave estrangeira
    private Integer category_id;
    private String category_name;
    private String category_description;
    private String url_image;

    public Category() {
    }

    public Category(Integer category_id, String category_name, String category_description, String url_image) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.category_description = category_description;
        this.url_image = url_image;
    }

//OneToMany

    @OneToMany()
    @JoinTable(name="product_category",
            joinColumns={@JoinColumn(name = "category_id")},
            inverseJoinColumns={@JoinColumn(name = "product_id")})
    private Set<Product> productList =new HashSet<>();


    //get e set


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


    public Set<Product> getProductList() {
        return productList;
    }

    public void setProductList(Set<Product> productList) {
        this.productList = productList;
    }
}

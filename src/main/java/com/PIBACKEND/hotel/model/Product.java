package com.PIBACKEND.hotel.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id//chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)//chave estrangeira
    private Integer product_id;
    private String product_name;
    private String product_description;

    //contrutores
    public Product(){}

    public Product(Integer product_id, String product_name, String product_description) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_description = product_description;
    }

//manyToMany

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="product_feature",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_id"))
    private Set<Feature> featureList =new HashSet<>();




    //manyToOne de produto e categoria

//    @ManyToOne
//    private Category category;
//
    @ManyToOne()
    private City city;

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

    public Set<Feature> getFeatureList() {
        return featureList;
    }

    public void setFeaturesSet(Set<Feature> featureSet) {
        this.featureList = featureSet;
    }




    //manyToOne
    // produto-categoria

//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }


//    //manyToOne
//    // produto-cidade

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}

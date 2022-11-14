package com.PIBACKEND.hotel.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
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

    public Product(Integer product_id, String product_name, String product_description, Set<Feature> featureList,
                   Category category_id, Zone zone_id, List<Image> images) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.featureList = featureList;
        this.category_id = category_id;
        this.zone_id = zone_id;
        this.images = images;
    }

    //manyToMany
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="product_feature",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_id"))
    private Set<Feature> featureList =new HashSet<>();




    //manyToOne
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category_id;

    @ManyToOne
    @JoinColumn(name="zone_id")
    private Zone zone_id;


    //OneToMany de image
    @OneToMany(mappedBy = "product_id")
    private List<Image> images;



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
    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }



    //OneToOne
    public Zone getZone_id() {
        return zone_id;
    }

    public void setZone_id(Zone zone_id) {
        this.zone_id = zone_id;
    }



    //oneToMany
    //product-Image
    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}

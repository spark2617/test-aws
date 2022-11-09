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
    private Integer productid;
    private String productname;
    private String productdescription;

    //contrutores
    public Product(){}

    public Product(Integer productid, String productname, String productdescription) {
        this.productid = productid;
        this.productname = productname;
        this.productdescription = productdescription;
    }

    //manyToMany
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="product_feature",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_id"))
    private Set<Feature> featureList =new HashSet<>();




    //manyToOne
    @ManyToOne
    @JoinColumn(name="categoryid")
    private Category categoryid;

    @OneToOne(mappedBy = "productid")
    @JoinColumn(name="zoneid")
    private Zone zoneid;



    //OneToMany de image
    @OneToMany(mappedBy = "productid")
    private List<Image> images;



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
    public Set<Feature> getFeatureList() {
        return featureList;
    }

    public void setFeaturesSet(Set<Feature> featureSet) {
        this.featureList = featureSet;
    }




    //manyToOne
    // produto-categoria

    public Category getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Category categoryid) {
        this.categoryid = categoryid;
    }


    //OneToOne


    public Zone getZoneid() {
        return zoneid;
    }

    public void setZoneid(Zone zoneid) {
        this.zoneid = zoneid;
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

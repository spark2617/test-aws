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
    private Integer categoryid;
    private String categoryname;
    private String categorydescription;
    private String urlimage;

    public Category() {
    }

    public Category(Integer categoryid, String categoryname, String categorydescription, String urlimage) {
        this.categoryid = categoryid;
        this.categoryname = categoryname;
        this.categorydescription = categorydescription;
        this.urlimage = urlimage;
    }

    //OneToMany

    @OneToMany(mappedBy = "categoryid")
    private Set<Product> lsProduct;


    //get e set


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


    public Set<Product> getLsProduct() {
        return lsProduct;
    }

    public void setLsProduct(Set<Product> lsProduct) {
        this.lsProduct = lsProduct;
    }
}

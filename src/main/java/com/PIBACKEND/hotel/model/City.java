package com.PIBACKEND.hotel.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class City implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id//chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)//chave estrangeira
    private Integer city_id;
    private String city_name;
    private String country;

    //construtor

    public City(){}

    public City(Integer city_id, String city_name, String country) {
        this.city_id = city_id;
        this.city_name = city_name;
        this.country = country;
    }

    //OneToMany
    @OneToMany(mappedBy = "citys")
    private List<Product> lsProducts;




    //get e set

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    //oneToMany


    public List<Product> getLsProducts() {
        return lsProducts;
    }

    public void setLsProducts(List<Product> lsProducts) {
        this.lsProducts = lsProducts;
    }
}

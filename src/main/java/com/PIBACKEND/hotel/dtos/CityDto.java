package com.PIBACKEND.hotel.dtos;

import com.PIBACKEND.hotel.model.City;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

public class CityDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer city_id;
    private String city_name;
    private String country;

    private Set<ProductDto> Products;

    public CityDto(){}

    public CityDto(Integer city_id, String name, String country) {
        this.city_id = city_id;
        this.city_name = name;
        this.country = country;
    }

    public CityDto(City model){
        this.city_id=model.getCity_id();
        this.city_name =model.getCity_name();
        this.country=model.getCountry();


    }

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


//OneToMany

    public Set<ProductDto> getProducts() {
        return Products;
    }

    public void setProducts(Set<ProductDto> Products) {
        this.Products = Products;
    }
}

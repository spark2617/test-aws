package com.PIBACKEND.hotel.dtos;

import java.io.Serializable;
import java.io.Serial;

public class ProductId implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer product_id;

    public ProductId(){}

    public ProductId(Integer product_id) {
        this.product_id = product_id;
    }

   //get e set


    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }
}

package com.PIBACKEND.hotel.dtos;

import com.PIBACKEND.hotel.model.Image;
import com.PIBACKEND.hotel.model.Product;

import javax.persistence.ManyToOne;
import java.io.Serial;
import java.io.Serializable;

public class ImageDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer imageid;
    private String title;
    private String urlimg;

    private ProductDto product_id;

    public ImageDto(){}

    public ImageDto(Integer image_id, String title, String url) {
        this.imageid = image_id;
        this.title = title;
        this.urlimg = url;
    }

    public ImageDto(Image model){
        this.imageid =model.getImageid();
        this.title=model.getTitle();
        this.urlimg=model.getUrlimg();

        this.product_id=new ProductDto(model.getProduct_id());


    }

    //get e set


    public Integer getImageid() {
        return imageid;
    }

    public void setImageid(Integer imageid) {
        this.imageid = imageid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlimg() {
        return urlimg;
    }

    public void setUrlimg(String urlimg) {
        this.urlimg = urlimg;
    }

    //manyToOne
    public ProductDto getProduct_id() {
        return product_id;
    }

    public void setProduct_id(ProductDto product_id) {
        this.product_id = product_id;
    }
}

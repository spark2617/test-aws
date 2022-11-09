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

    private ProductDto productid;

    public ImageDto(){}

    public ImageDto(Integer imageid, String title, String urlimg) {
        this.imageid = imageid;
        this.title = title;
        this.urlimg = urlimg;
    }

    public ImageDto(Image model){
        this.imageid =model.getImageid();
        this.title=model.getTitle();
        this.urlimg=model.getUrlimg();

        this.productid=new ProductDto(model.getProductid());


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
    public ProductDto getProductid() {
        return productid;
    }

    public void setProductid(ProductDto product_id) {
        this.productid = product_id;
    }
}

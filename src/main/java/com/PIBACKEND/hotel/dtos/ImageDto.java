package com.PIBACKEND.hotel.dtos;

import com.PIBACKEND.hotel.model.Image;
import com.PIBACKEND.hotel.model.Product;

import javax.persistence.ManyToOne;
import java.io.Serial;
import java.io.Serializable;

public class ImageDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer image_id;
    private String title;
    private String url_img;

    private ProductDto product_id;

    public ImageDto(){}

    public ImageDto(Integer image_id, String title, String url) {
        this.image_id = image_id;
        this.title = title;
        this.url_img = url;
    }

    public ImageDto(Image model){
        this.image_id =model.getImage_id();
        this.title=model.getTitle();
        this.url_img=model.getUrl_img();

        


    }

    //get e set
    public Integer getImage_id() {
        return image_id;
    }

    public void setImage_id(Integer image_id) {
        this.image_id = image_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }



    //manyToOne
    public ProductDto getProduct_id() {
        return product_id;
    }

    public void setProduct_id(ProductDto product_id) {
        this.product_id = product_id;
    }
}

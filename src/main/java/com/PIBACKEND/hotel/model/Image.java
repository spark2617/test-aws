package com.PIBACKEND.hotel.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Image implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id//chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)//chave estrangeira
    private Integer image_id;
    private String title;
    private String url_img;



    //construtor
    public Image(){}

    public Image(Integer images_id, String title, String url_img) {
        this.image_id = images_id;
        this.title = title;
        this.url_img = url_img;
    }



    @ManyToOne
    private Product product_id;




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

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }
}

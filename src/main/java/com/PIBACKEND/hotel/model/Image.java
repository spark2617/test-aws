package com.PIBACKEND.hotel.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Image implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id//chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)//chave estrangeira
    private Integer imageid;
    private String title;
    private String urlimg;



    //construtor
    public Image(){}

    public Image(Integer imageid, String title, String urlimg) {
        this.imageid = imageid;
        this.title = title;
        this.urlimg = urlimg;
    }

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product_id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getImageid() {
        return imageid;
    }

    public void setImageid(Integer imageid) {
        this.imageid = imageid;
    }

    public String getUrlimg() {
        return urlimg;
    }

    public void setUrlimg(String urlimg) {
        this.urlimg = urlimg;
    }


    //manyToOne

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }
}

package com.PIBACKEND.hotel.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id//chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)//chave estrangeira
    private Integer product_id;
    private String product_name;
    private String product_description;

    //contrutores
    public Product(){}

    public Product(Integer product_id, String product_name, String product_description, Set<Feature> featureList,
                   Category category_id, Zone zone_id, List<Image> images) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.featureList = featureList;
        this.category_id = category_id;
        this.zone_id = zone_id;
        this.images = images;
    }

    //manyToMany
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="product_feature",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_id"))
    private Set<Feature> featureList =new HashSet<>();




    //manyToOne
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category_id;

    @ManyToOne
    @JoinColumn(name="zone_id")
    private Zone zone_id;


    //OneToMany
    @OneToMany(mappedBy = "product_id")
    private List<Image> images;

    @OneToMany(mappedBy = "product_id")
    private List<Reservation> reservations;

}

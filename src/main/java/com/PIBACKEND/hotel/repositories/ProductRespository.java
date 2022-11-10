package com.PIBACKEND.hotel.repositories;


import com.PIBACKEND.hotel.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRespository extends JpaRepository<Product, Integer> {

//    List<Product> findByCityCity_name(String name);
    @Query(value = "SELECT * FROM product WHERE category_id = 1;", nativeQuery = true)
    List<Product> findByAllProduct();


    @Query(value = "SELECT product.product_id, product.product_name,product.product_description, product.category_id,\n" +
            " product.zone_id\n" +
            " FROM product INNER JOIN zone \n" +
            " ON product.zone_id = zone.zone_id\n" +
            " WHERE zone.metaverse_id = 1;", nativeQuery = true)
    List<Product> findByAllProductMetaverse();
}

package com.PIBACKEND.hotel.repositories;


import com.PIBACKEND.hotel.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRespository extends JpaRepository<Product, Integer> {

//    List<Product> findByCityCity_name(String name);
    @Query(value = "SELECT * FROM product WHERE category_id = 1;", nativeQuery = true)
    List<Product> findByAllProduct();
    @Query(value = "SELECT * FROM product INNER JOIN category WHERE category.category_name=:name", nativeQuery = true)
    List<Product> findByProduct(@Param("name") String name);

}

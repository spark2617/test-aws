package com.PIBACKEND.hotel.repositories;


import com.PIBACKEND.hotel.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRespository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM product INNER JOIN category ON product.category_id = category.category_id WHERE category.category_name = hotel;",nativeQuery = true)
    List<Product> findByCategory();
}

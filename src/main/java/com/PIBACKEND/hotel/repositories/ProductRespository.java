package com.PIBACKEND.hotel.repositories;


import com.PIBACKEND.hotel.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRespository extends JpaRepository<Product, Integer> {

    @Query("select p from Product p where p.product_id=7")
    List<Product> findByCategory();
}

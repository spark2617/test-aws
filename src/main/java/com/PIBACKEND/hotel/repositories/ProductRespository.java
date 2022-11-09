package com.PIBACKEND.hotel.repositories;


import com.PIBACKEND.hotel.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRespository extends JpaRepository<Product, Integer> {

//    List<Product> findByMetaverseMetaversename(String name);
    List<Product> findByCategoryCategoryname(String name);

}

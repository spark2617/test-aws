package com.PIBACKEND.hotel.repositories;

import com.PIBACKEND.hotel.model.Acess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcessRepository extends JpaRepository<Acess,Integer> {



}

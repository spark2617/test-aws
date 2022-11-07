package com.PIBACKEND.hotel.repositories;


import com.PIBACKEND.hotel.model.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Integer> {



}

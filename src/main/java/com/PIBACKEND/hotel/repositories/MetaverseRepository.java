package com.PIBACKEND.hotel.repositories;

import com.PIBACKEND.hotel.model.Metaverse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaverseRepository extends JpaRepository<Metaverse, Integer> {

}

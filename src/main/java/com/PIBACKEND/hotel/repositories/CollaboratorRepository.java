package com.PIBACKEND.hotel.repositories;

import com.PIBACKEND.hotel.model.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator, Integer> {

    @Query("select p from Collaborator p where email=:email")
    Collaborator findByEmail(@Param("email") String email);
}

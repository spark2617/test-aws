package com.PIBACKEND.hotel.repositories;

import com.PIBACKEND.hotel.model.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator, Integer> {

    Collaborator findByEmail(String email);
}

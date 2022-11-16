package com.PIBACKEND.hotel.repositories;

import com.PIBACKEND.hotel.model.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator, Integer> {

    Optional<Collaborator> findByEmail(String email);
}

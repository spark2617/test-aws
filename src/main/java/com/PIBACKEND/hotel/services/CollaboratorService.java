package com.PIBACKEND.hotel.services;

import com.PIBACKEND.hotel.dtos.CollaboratorDto;
import com.PIBACKEND.hotel.dtos.CollaboratorInsertDto;
import com.PIBACKEND.hotel.dtos.CollaboratorUpdateDto;
import com.PIBACKEND.hotel.model.Acess;
import com.PIBACKEND.hotel.model.Collaborator;
import com.PIBACKEND.hotel.repositories.AcessRepository;
import com.PIBACKEND.hotel.repositories.CollaboratorRepository;
import com.PIBACKEND.hotel.services.exceptions.EntityNotFoundExceptionHotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollaboratorService implements UserDetailsService {

    @Autowired
    private CollaboratorRepository repository;

    @Autowired
    private AcessRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public List<CollaboratorDto> findAll() {
        List<Collaborator> list = repository.findAll();
        return list.stream().map(x -> new CollaboratorDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CollaboratorDto findById(Integer id) {
        Optional<Collaborator> object = repository.findById(id);
        Collaborator entity = object.orElseThrow(() ->
                new EntityNotFoundExceptionHotel("Este ID não existe em nosso sistema."));
        return new CollaboratorDto(entity);
    }

    public void delete(Integer id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundExceptionHotel("Id não encontrado: " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new EntityNotFoundExceptionHotel("Violação de integridade no banco de dados.");
        }
    }

    @Transactional
    public CollaboratorDto insert(CollaboratorInsertDto dto) {
        Collaborator entity = new Collaborator();
        copyDtoToEntity(dto, entity);
//        entity.setPassword(passwordEncoder.encode(dto.getPassword())); //dh2022
        entity.setCollaborator_password(passwordEncoder.encode(dto.getCollaborator_password()));
        entity = repository.save(entity);
        return new CollaboratorDto(entity);
    }

    @Transactional
    public CollaboratorDto update(Integer id, CollaboratorUpdateDto dto) {
        try {
            Collaborator entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new CollaboratorDto(entity);
        }
        catch (EntityNotFoundException e) {
            throw new EntityNotFoundExceptionHotel("Id não encontrado: " + id);
        }
    }

    private void copyDtoToEntity(CollaboratorDto dto, Collaborator entity) {

        entity.setCollaborator_name(dto.getCollaborator_name());
        entity.setCollaborator_surname(dto.getCollaborator_surname());
        entity.setEmail(dto.getEmail());
        Acess acess = roleRepository.getReferenceById(dto.getCollaborator_id());
        entity.setAcess(acess);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws EntityNotFoundExceptionHotel {
        Collaborator user = repository.findByEmail(username);
        if (user == null) {
            throw new EntityNotFoundExceptionHotel("Você digitou um e-mail inválido!");
        }
        return user;
    }

}

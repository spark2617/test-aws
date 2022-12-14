package com.PIBACKEND.hotel.services;

import com.PIBACKEND.hotel.dtos.CategoryDto;
import com.PIBACKEND.hotel.dtos.CollaboratorDto;
import com.PIBACKEND.hotel.model.Acess;
import com.PIBACKEND.hotel.model.Category;
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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CollaboratorService{

    @Autowired
    private CollaboratorRepository userRepository;

    @Autowired
    private AcessRepository roleRepository;

//    @Autowired
//    private ReservRepository bookingRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Transactional(readOnly = true)
    public CollaboratorDto getId(Integer id) {

        Optional<Collaborator> obj = userRepository.findById(id);
        Collaborator entity = obj.orElseThrow(() -> new EntityNotFoundExceptionHotel("Record "+id+" not found!"));
        return new CollaboratorDto(entity);

    }
    @Transactional
    public CollaboratorDto createUser(CollaboratorDto dto) {
        Collaborator entity = new Collaborator();
        dto.setCollaborator_password(encoder.encode(dto.getCollaborator_password()));
        copyToEntity(dto, entity);
        entity = userRepository.save(entity);
        return new CollaboratorDto(entity);
    }

    @Transactional(readOnly = true)
    public List<CollaboratorDto> getAll() {
        List<CollaboratorDto> listDto = new ArrayList<>();
        List<Collaborator> list = userRepository.findAll();
        for(Collaborator user : list) {
            CollaboratorDto dto = new CollaboratorDto(user);
            listDto.add(dto);
        }
        return listDto;
    }
    public Collaborator fetchEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void delete(Integer id) {
        try {userRepository.deleteById(id);}
        catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundExceptionHotel("Record "+id+"not found!");
        }
    }


    public void copyToEntity(CollaboratorDto dto, Collaborator entiity){
        entiity.setCollaborator_name(dto.getCollaborator_name());
        entiity.setCollaborator_surname(dto.getCollaborator_surname());
        entiity.setEmail(dto.getEmail());
        Optional<Acess> obj=roleRepository.findById(dto.getAcess_id().getAcess_id());
        Acess acess=obj.orElseThrow(()-> new EntityNotFoundExceptionHotel("entity invalid!"));
        entiity.setAcess_id(acess);

    }

}

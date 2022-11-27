package com.PIBACKEND.hotel.services;

import com.PIBACKEND.hotel.dtos.ReservationDto;
import com.PIBACKEND.hotel.model.Collaborator;
import com.PIBACKEND.hotel.model.Product;
import com.PIBACKEND.hotel.model.Reservation;
import com.PIBACKEND.hotel.repositories.CollaboratorRepository;
import com.PIBACKEND.hotel.repositories.ProductRespository;
import com.PIBACKEND.hotel.repositories.ReservationRepository;
import com.PIBACKEND.hotel.services.exceptions.EntityNotFoundExceptionHotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ReservationService {


    @Autowired
    private ReservationRepository repository;

    @Autowired
    private ProductRespository productRespository;

    @Autowired
    private CollaboratorRepository collaboratorRepository;


    @Transactional(readOnly = true)
    public List<ReservationDto> getAll() {
        try {
            List<Reservation> list = repository.findAll();
            return list.stream().map(ReservationDto::new).collect(Collectors.toList());
        }
        catch(EntityNotFoundException e){
            throw new EntityNotFoundExceptionHotel("Record not found!");
        }
    }

    @Transactional(readOnly = true)
    public ReservationDto getId(Integer id) {

        Optional<Reservation> obj = repository.findById(id);
        Reservation entity = obj.orElseThrow(() -> new EntityNotFoundExceptionHotel("Record "+id+" not found!"));
        return new ReservationDto(entity);

    }

    public void delete(Integer id) {
        try {repository.deleteById(id);}
        catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundExceptionHotel("Record "+id+"not found!");
        }
    }

    //criar reserva
    @Transactional
    public ReservationDto create(ReservationDto dto){
        Reservation entity=new Reservation();
        copyToEntity(dto,entity);
        entity=repository.save(entity);
        return new ReservationDto(entity);
    }

    public void copyToEntity(ReservationDto dto, Reservation entity){
        entity.setCheckin_date(dto.getCheckin_date());
        entity.setCheckin_time(dto.getCheckin_time());
        entity.setCheckout_date(dto.getCheckout_date());
        entity.setCheckout_time(dto.getCheckout_time());

        Optional<Product> obj=productRespository.findById(dto.getProduct_id());
        Product product=obj.orElseThrow(()-> new EntityNotFoundExceptionHotel("product invalid!"));
        entity.setProduct_id(product);

        Optional<Collaborator> objCollaborator=collaboratorRepository.findById(dto.getCollaborator_id());
        Collaborator collaborator=objCollaborator.orElseThrow(()-> new EntityNotFoundExceptionHotel("usuario invalid!"));
        entity.setCollaborator_id(collaborator);
    }

}

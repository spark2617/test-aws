package com.PIBACKEND.hotel.services;

import com.PIBACKEND.hotel.dtos.ReservationDto;
import com.PIBACKEND.hotel.model.Reservation;
import com.PIBACKEND.hotel.repositories.ReservationRepository;
import com.PIBACKEND.hotel.services.exceptions.EntityNotFoundExceptionHotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReservationService {


    @Autowired
    private ReservationRepository repository;


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


}

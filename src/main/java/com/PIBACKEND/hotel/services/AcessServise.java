package com.PIBACKEND.hotel.services;

import com.PIBACKEND.hotel.dtos.AcessDto;
import com.PIBACKEND.hotel.model.Acess;
import com.PIBACKEND.hotel.repositories.AcessRepository;
import com.PIBACKEND.hotel.services.exceptions.EntityNotFoundExceptionHotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class AcessServise {


    @Autowired
    private AcessRepository repository;


    @Transactional(readOnly = true)
    public List<AcessDto> getAll() {
        try {
            List<Acess> list = repository.findAll();
            return list.stream().map(AcessDto::new).collect(Collectors.toList());
        }
        catch(EntityNotFoundException e){
            throw new EntityNotFoundExceptionHotel("Record not found!");
        }
    }

}

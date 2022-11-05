package com.PIBACKEND.hotel.services;

import com.PIBACKEND.hotel.dtos.CityDto;
import com.PIBACKEND.hotel.model.City;
import com.PIBACKEND.hotel.repositories.CityRepository;
import com.PIBACKEND.hotel.services.exceptions.EntityNotFoundExceptionHotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    //listar todas as cidade
    @Transactional(readOnly = true)
    public List<CityDto> getAll() {
        try {
            List<City> list = repository.findAll();
            return list.stream().map(CityDto::new).collect(Collectors.toList());
        }
        catch(EntityNotFoundException e){
            throw new EntityNotFoundExceptionHotel("Record not found!");
        }
    }


    //criar uma cidade

    @Transactional
    public CityDto insert(CityDto dto) {

        City entity = new City();

        entity.setCity_name(dto.getCity_name());
        entity.setCountry(dto.getCountry());

        entity = repository.save(entity);
        return new CityDto(entity);
    }


}

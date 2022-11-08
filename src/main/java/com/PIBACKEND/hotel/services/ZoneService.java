package com.PIBACKEND.hotel.services;

import com.PIBACKEND.hotel.dtos.ZoneDto;
import com.PIBACKEND.hotel.model.Zone;
import com.PIBACKEND.hotel.repositories.ZoneRepository;
import com.PIBACKEND.hotel.services.exceptions.EntityNotFoundExceptionHotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZoneService {

    @Autowired
    private ZoneRepository repository;

    //listar todas as cidade
    @Transactional(readOnly = true)
    public List<ZoneDto> getAll() {
        try {
            List<Zone> list = repository.findAll();
            return list.stream().map(ZoneDto::new).collect(Collectors.toList());
        }
        catch(EntityNotFoundException e){
            throw new EntityNotFoundExceptionHotel("Record not found!");
        }
    }


    //criar uma cidade

    @Transactional
    public ZoneDto insert(ZoneDto dto) {

        Zone entity = new Zone();

        entity.setLatitude(dto.getLatitude());
        entity.setLongitude(dto.getLongitude());


        entity = repository.save(entity);
        return new ZoneDto(entity);
    }


}

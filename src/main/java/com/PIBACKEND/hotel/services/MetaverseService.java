package com.PIBACKEND.hotel.services;

import com.PIBACKEND.hotel.dtos.MetaverseDto;
import com.PIBACKEND.hotel.model.Metaverse;
import com.PIBACKEND.hotel.repositories.MetaverseRepository;
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
public class MetaverseService {


    @Autowired
    private MetaverseRepository repository;


    @Transactional(readOnly = true)
    public List<MetaverseDto> getAll() {
        try {
            List<Metaverse> list = repository.findAll();
            return list.stream().map(MetaverseDto::new).collect(Collectors.toList());
        }
        catch(EntityNotFoundException e){
            throw new EntityNotFoundExceptionHotel("Record not found!");
        }
    }

    @Transactional(readOnly = true)
    public MetaverseDto getId(Integer id) {

        Optional<Metaverse> obj = repository.findById(id);
        Metaverse entity = obj.orElseThrow(() -> new EntityNotFoundExceptionHotel("Record "+id+" not found!"));
        return new MetaverseDto(entity);

    }

    public void delete(Integer id) {
        try {repository.deleteById(id);}
        catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundExceptionHotel("Record "+id+"not found!");
        }
    }

    @Transactional
    public MetaverseDto insert(MetaverseDto dto) {

        Metaverse entity = new Metaverse();

        entity.setMetaverse_name(dto.getMetaverse_name());

        entity = repository.save(entity);
        return new MetaverseDto(entity);
    }
}

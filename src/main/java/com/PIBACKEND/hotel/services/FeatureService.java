package com.PIBACKEND.hotel.services;

import com.PIBACKEND.hotel.dtos.FeatureDto;
import com.PIBACKEND.hotel.model.Feature;
import com.PIBACKEND.hotel.repositories.FeatureRepository;
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
public class FeatureService {

    @Autowired
    private FeatureRepository repository;


    @Transactional(readOnly = true)
    public List<FeatureDto> getAll() {
        try {
            List<Feature> list = repository.findAll();
            return list.stream().map(FeatureDto::new).collect(Collectors.toList());
        }
        catch(EntityNotFoundException e){
            throw new EntityNotFoundExceptionHotel("Record not found!");
        }
    }

    @Transactional(readOnly = true)
    public FeatureDto getId(Integer id) {

        Optional<Feature> obj = repository.findById(id);
        Feature entity = obj.orElseThrow(() -> new EntityNotFoundExceptionHotel("Record "+id+" not found!"));
        return new FeatureDto(entity);

    }

    public void delete(Integer id) {
        try {repository.deleteById(id);}
        catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundExceptionHotel("Record "+id+"not found!");
        }
    }

    @Transactional
    public FeatureDto insert(FeatureDto dto) {

        Feature entity = new Feature();

        entity.setFeaturename(dto.getFeaturename());
        entity.setIcon(dto.getIcon());

        entity = repository.save(entity);
        return new FeatureDto(entity);
    }

}

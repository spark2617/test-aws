package com.PIBACKEND.hotel.services;

import com.PIBACKEND.hotel.dtos.ImageDto;
import com.PIBACKEND.hotel.model.Image;
import com.PIBACKEND.hotel.repositories.ImageRepository;
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
public class ImageService {

    @Autowired
    private ImageRepository repository;


    @Transactional(readOnly = true)
    public List<ImageDto> getAll() {
        try {
            List<Image> list = repository.findAll();
            return list.stream().map(ImageDto::new).collect(Collectors.toList());
        }
        catch(EntityNotFoundException e){
            throw new EntityNotFoundExceptionHotel("Record not found!");
        }
    }

    @Transactional(readOnly = true)
    public ImageDto getId(Integer id) {

        Optional<Image> obj = repository.findById(id);
        Image entity = obj.orElseThrow(() -> new EntityNotFoundExceptionHotel("Record "+id+" not found!"));
        return new ImageDto(entity);

    }

    public void delete(Integer id) {
        try {repository.deleteById(id);}
        catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundExceptionHotel("Record "+id+"not found!");
        }
    }

    @Transactional
    public ImageDto insert(ImageDto dto) {

        Image entity = new Image();

        entity.setTitle(dto.getTitle());
        entity.setUrlimg(dto.getUrlimg());

        entity = repository.save(entity);
        return new ImageDto(entity);
    }

}

package com.PIBACKEND.hotel.services;

import com.PIBACKEND.hotel.dtos.CategoryDto;
import com.PIBACKEND.hotel.model.Category;
import com.PIBACKEND.hotel.repositories.CategoryRepository;
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
public class CategoryService{

    @Autowired
    private CategoryRepository repository;


    @Transactional(readOnly = true)
    public List<CategoryDto> getAll() {
        try {
            List<Category> list = repository.findAll();
            return list.stream().map(CategoryDto::new).collect(Collectors.toList());
        }
        catch(EntityNotFoundException e){
            throw new EntityNotFoundExceptionHotel("Record not found!");
        }
    }

    @Transactional(readOnly = true)
    public CategoryDto getId(Integer id) {

        Optional<Category> obj = repository.findById(id);
        Category entity = obj.orElseThrow(() -> new EntityNotFoundExceptionHotel("Record "+id+" not found!"));
        return new CategoryDto(entity);

    }

    public void delete(Integer id) {
        try {repository.deleteById(id);}
        catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundExceptionHotel("Record "+id+"not found!");
        }
    }

    @Transactional
    public CategoryDto insert(CategoryDto dto) {

        Category entity = new Category();

        entity.setQualification(dto.getQualification());
        entity.setCategory_description(dto.getCategory_description());
        entity.setUrl_image(dto.getUrl_image());

        entity = repository.save(entity);
        return new CategoryDto(entity);
    }






}

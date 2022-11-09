package com.PIBACKEND.hotel.services;

import com.PIBACKEND.hotel.dtos.ProductDto;
import com.PIBACKEND.hotel.model.Product;
import com.PIBACKEND.hotel.repositories.ProductRespository;
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
public class ProductService {

    @Autowired
    private ProductRespository repository;


    @Transactional(readOnly = true)
    public List<ProductDto> getAll() {
        try {
            List<Product> list = repository.findAll();
            return list.stream().map(ProductDto::new).collect(Collectors.toList());
        }
        catch(EntityNotFoundException e){
            throw new EntityNotFoundExceptionHotel("Record not found!");
        }
    }

    @Transactional(readOnly = true)
    public ProductDto getId(Integer id) {

        Optional<Product> obj = repository.findById(id);
        Product entity = obj.orElseThrow(() -> new EntityNotFoundExceptionHotel("Record "+id+" not found!"));
        return new ProductDto(entity);

    }

    public void delete(Integer id) {
        try {
            repository.deleteById(id);}
        catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundExceptionHotel("Record "+id+"not found!");
        }
    }

    @Transactional
    public ProductDto insert(ProductDto dto) {

        Product entity = new Product();

        entity.setProductname(dto.getProductname());
        entity.setProductdescription(dto.getProductdescription());

        entity = repository.save(entity);
        return new ProductDto(entity);
    }

    //buscar product pelo metaverse
//
//    @Transactional(readOnly = true)
//    public List<ProductDto> getProductZone(String name) {
//        try {
//            List<Product> list = repository.findByMetaverseMetaverse_name(name);
//            return list.stream().map(ProductDto::new).collect(Collectors.toList());
//        }
//        catch(EntityNotFoundException e){
//            throw new EntityNotFoundExceptionHotel("Record not found!");
//        }
//    }



    //buscar product pela categoria
    @Transactional(readOnly = true)
    public List<ProductDto> getProductCategory(String name) {
        try {
            List<Product> list = repository.findByCategoryCategoryname(name);
            return list.stream().map(ProductDto::new).collect(Collectors.toList());
        }
        catch(EntityNotFoundException e){
            throw new EntityNotFoundExceptionHotel("Record not found!");
        }
    }


}

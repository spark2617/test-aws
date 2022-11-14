package com.PIBACKEND.hotel.controller;


import com.PIBACKEND.hotel.dtos.ProductDto;
import com.PIBACKEND.hotel.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProduct() {
        List<ProductDto> list = service.getAll();
        return ResponseEntity.ok().body(list);
    }

    //test
    @GetMapping(value = "test")
    public ResponseEntity<List<ProductDto>> getAll() {
        List<ProductDto> list = service.getAllCategory();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDto> getProductForId(@PathVariable Integer id) {
        ProductDto dto = service.getId(id);
        return ResponseEntity.ok().body(dto);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping
    public ResponseEntity<ProductDto> insertProduct(@RequestBody ProductDto dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getProduct_id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}

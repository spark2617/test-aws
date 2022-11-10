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
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProduct() {
        List<ProductDto> list = service.getAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/product/{id}")
    public ResponseEntity<ProductDto> getProductForId(@PathVariable Integer id) {
        ProductDto dto = service.getId(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/product/{name}")
    public ResponseEntity<List<ProductDto>> getProductToCategoryName(@PathVariable String name) {
        List<ProductDto> list = service.getProductCategory(name);
        return ResponseEntity.ok().body(list);
    }


    @DeleteMapping(value = "delete/{id}")
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

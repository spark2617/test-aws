package com.PIBACKEND.hotel.controller;

import com.PIBACKEND.hotel.dtos.CategoryDto;
import com.PIBACKEND.hotel.dtos.MetaverseDto;
import com.PIBACKEND.hotel.model.Metaverse;
import com.PIBACKEND.hotel.services.CategoryService;
import com.PIBACKEND.hotel.services.MetaverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/metaverse")
public class MetaverseController {

    @Autowired
    MetaverseService service;

    @GetMapping
    public ResponseEntity<List<MetaverseDto>> getAllCategories() {
        List<MetaverseDto> list = service.getAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MetaverseDto> getCategoryForId(@PathVariable Integer id) {
        MetaverseDto dto = service.getId(id);
        return ResponseEntity.ok().body(dto);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping
    public ResponseEntity<MetaverseDto> insertCategory(@RequestBody MetaverseDto dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getMetaverse_id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}

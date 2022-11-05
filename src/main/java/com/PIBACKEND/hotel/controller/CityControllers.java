package com.PIBACKEND.hotel.controller;

import com.PIBACKEND.hotel.dtos.CityDto;
import com.PIBACKEND.hotel.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/cities")
public class CityControllers {

    @Autowired
    private CityService service;

    @GetMapping
    public ResponseEntity<List<CityDto>> getAllCities() {
        List<CityDto> list = service.getAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<CityDto> insertCities(@RequestBody CityDto dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getCity_id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}

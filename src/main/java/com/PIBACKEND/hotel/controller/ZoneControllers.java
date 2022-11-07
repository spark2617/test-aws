package com.PIBACKEND.hotel.controller;

import com.PIBACKEND.hotel.dtos.ZoneDto;
import com.PIBACKEND.hotel.services.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/cities")
public class ZoneControllers {

    @Autowired
    private ZoneService service;

    @GetMapping
    public ResponseEntity<List<ZoneDto>> getAllCities() {
        List<ZoneDto> list = service.getAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<ZoneDto> insertCities(@RequestBody ZoneDto dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getZone_id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}

package com.PIBACKEND.hotel.controller;

import com.PIBACKEND.hotel.dtos.CategoryDto;
import com.PIBACKEND.hotel.dtos.ReservationDto;
import com.PIBACKEND.hotel.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {

    @Autowired
    private ReservationService service;

    @GetMapping
    public ResponseEntity<List<ReservationDto>> getAllProduct() {
        List<ReservationDto> list = service.getAll();
        return ResponseEntity.ok().body(list);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<ReservationDto> getProductForId(@PathVariable Integer id) {
        ReservationDto dto = service.getId(id);
        return ResponseEntity.ok().body(dto);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ReservationDto> insertCategory(@RequestBody ReservationDto dto) {
        dto = service.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getReservation_id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }


}

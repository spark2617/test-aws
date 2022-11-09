package com.PIBACKEND.hotel.controller;

import com.PIBACKEND.hotel.dtos.FeatureDto;
import com.PIBACKEND.hotel.services.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/features")
public class FeatureController {

    @Autowired
    private FeatureService service;


    @GetMapping
    public ResponseEntity<List<FeatureDto>> getAllfeatures() {
        List<FeatureDto> list = service.getAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FeatureDto> getFeaturesForId(@PathVariable Integer id) {
        FeatureDto dto = service.getId(id);
        return ResponseEntity.ok().body(dto);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping
    public ResponseEntity<FeatureDto> insertFeatures(@RequestBody FeatureDto dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getFeature_id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}

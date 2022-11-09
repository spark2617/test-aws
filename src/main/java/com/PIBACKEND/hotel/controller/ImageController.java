package com.PIBACKEND.hotel.controller;

import com.PIBACKEND.hotel.dtos.ImageDto;
import com.PIBACKEND.hotel.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/Image")
public class ImageController {

    @Autowired
    private ImageService service;

    @GetMapping
    public ResponseEntity<List<ImageDto>> getAllImages() {
        List<ImageDto> list = service.getAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ImageDto> getImagesForId(@PathVariable Integer id) {
        ImageDto dto = service.getId(id);
        return ResponseEntity.ok().body(dto);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteImages(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping
    public ResponseEntity<ImageDto> insertImages(@RequestBody ImageDto dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getImageid()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }


}

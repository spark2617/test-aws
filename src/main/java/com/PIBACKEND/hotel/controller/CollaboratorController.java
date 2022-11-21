package com.PIBACKEND.hotel.controller;

import com.PIBACKEND.hotel.dtos.CollaboratorDto;
import com.PIBACKEND.hotel.services.CollaboratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/collaborator")
public class CollaboratorController {

    @Autowired
    CollaboratorService service;

    @GetMapping
    public ResponseEntity<List<CollaboratorDto>> buscarTodos() {
        List<CollaboratorDto> list = service.getAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CollaboratorDto> buscarPorId(@PathVariable Integer id) {
        CollaboratorDto dto = service.getId(id);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}

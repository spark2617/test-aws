package com.PIBACKEND.hotel.controller;

import com.PIBACKEND.hotel.dtos.AcessDto;
import com.PIBACKEND.hotel.dtos.CategoryDto;
import com.PIBACKEND.hotel.services.AcessServise;
import com.PIBACKEND.hotel.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping(value = "/acess")
public class AcessController {


    @Autowired
    AcessServise service;

    @GetMapping
    public ResponseEntity<List<AcessDto>> getAllAcess() {
        List<AcessDto> list = service.getAll();
        return ResponseEntity.ok().body(list);
    }

}

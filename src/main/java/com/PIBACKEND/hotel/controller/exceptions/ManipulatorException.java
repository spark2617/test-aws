package com.PIBACKEND.hotel.controller.exceptions;

import com.PIBACKEND.hotel.services.exceptions.EntityNotFoundExceptionHotel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ManipulatorException {

    @ExceptionHandler(EntityNotFoundExceptionHotel.class)
    public ResponseEntity<ErrorHotel> entityNotFound(EntityNotFoundExceptionHotel e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorHotel error = new ErrorHotel();
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Record not found!");
        error.setMsg(e.getMessage());
        error.setLink(request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    /*@ExceptionHandler(DatabaseHotelException.class)
    public ResponseEntity<ErrorHotel> integrityViolation(DatabaseHotelException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorHotel error = new ErrorHotel();
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Integrity violation (Constrain key)!");
        error.setMsg(e.getMessage());
        error.setLink(request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }*/

}




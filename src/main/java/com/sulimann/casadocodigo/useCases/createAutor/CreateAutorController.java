package com.sulimann.casadocodigo.useCases.createAutor;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sulimann.casadocodigo.entities.Autor;
import com.sulimann.casadocodigo.repositories.AutorRepository;

@RestController
public class CreateAutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping(value = "/api/autor")
    public ResponseEntity<Object> createNewAutor(@Valid @RequestBody CreateAutorDto autorDto){
        Autor newAutor = autorDto.convertToAutorModel();
        autorRepository.save(newAutor);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAutor);
    }
    
}

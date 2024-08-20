package com.cdc.autor;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/autor")
public class AutorController {

    private final AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<String> novo(@RequestBody @Valid NovoAutorRequest request) {
        Autor autor = request.toModel();
        autorRepository.save(autor);

        return ResponseEntity.ok(autor.toString());
    }
}

package br.com.kleberson2santos.casadocodigov1.novoautor;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
public class AutoresController {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @PostMapping("/autores")
    public String novo(@RequestBody @Valid NovoAutorRequest request){
        Autor autor = request.toModel();
        manager.persist(autor);
        return autor.toString();
    }
}

package com.tiozao.cdd.loja.controller.api

import com.tiozao.cdd.loja.controller.extensions.toModel
import com.tiozao.cdd.loja.controller.extensions.toResponse
import com.tiozao.cdd.loja.controller.model.LivroRequest
import com.tiozao.cdd.loja.controller.model.LivroResponse
import com.tiozao.cdd.loja.domain.service.LivroService
import com.tiozao.cdd.loja.repository.extensions.toEntity
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@Validated
class LivroController(private var livroService: LivroService) {

    @GetMapping("/livros/{id}")
    fun findLivro(@PathVariable("id") id: Int): ResponseEntity<LivroResponse> {
        livroService.findLivro(id)
            ?.let { return ResponseEntity.ok(it.toResponse()) }
            .run { return ResponseEntity.notFound().build() }
    }


    @PostMapping("/livros")
    fun createLivro(@Valid @RequestBody livro: LivroRequest): ResponseEntity<LivroResponse>{
        return ResponseEntity.ok(livroService
            .createLivro( livro.toModel() )
            .toResponse())
    }

}
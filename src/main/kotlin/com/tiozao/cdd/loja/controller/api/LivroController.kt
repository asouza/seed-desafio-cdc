package com.tiozao.cdd.loja.controller.api

import com.tiozao.cdd.loja.domain.model.LivroModel
import com.tiozao.cdd.loja.domain.service.AutorService
import com.tiozao.cdd.loja.domain.service.CategoriaService
import com.tiozao.cdd.loja.domain.service.LivroService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@Validated
class LivroController(
    private var livroService: LivroService,
    private var categoriaService: CategoriaService,
    private var autorService: AutorService) {

    @GetMapping("/livros/{id}")
    fun findLivro(@PathVariable("id") id: Int): ResponseEntity<LivroModel> {
        livroService.findLivro(id)
            ?.let { return ResponseEntity.ok( it )
            }.run { return ResponseEntity.notFound().build() }
    }

    @GetMapping("/livros")
    fun findAllLivro(
        @RequestParam(name = "page", defaultValue = "0") page: Int,
        @RequestParam(name = "size", defaultValue = "20") size: Int,
        @RequestParam(name = "direction", defaultValue = "ASC") direction: String,
        @RequestParam(name = "sortBy", defaultValue = "titulo") sortBy: String
    ): ResponseEntity<Page<LivroModel>> {
        return ResponseEntity.ok(
            livroService.findAllLivro(
                PageRequest.of(page, size, getSort(direction, sortBy))
            ))
    }


    @PostMapping("/livros")
    fun createLivro(@Valid @RequestBody livro: LivroModel): ResponseEntity<LivroModel> {
        return ResponseEntity.ok(
            livroService
                .createLivro(livro))
    }

    companion object {
        var FIELD_FILTERS = listOf<String>(
            "id", "titulo", "sumario", "resumo", "preco", "numeroPaginas", "isbn", "dataPublicacao", "categoriaId",
            "autorId", "instante"
        )
    }

    private fun getSort(direction: String, sortBy: String): Sort {
        if(FIELD_FILTERS.contains(sortBy)) {
            return Sort.by(Sort.Direction.valueOf(direction), sortBy)
        }else {
            return Sort.by(Sort.Direction.valueOf(direction), FIELD_FILTERS.get(1))
        }
    }

}
package com.tiozao.cdd.loja.controller.api

import com.tiozao.cdd.loja.domain.model.CategoriaModel
import com.tiozao.cdd.loja.domain.service.CategoriaService

import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@Validated
class CategoriaController(private var categoriaService: CategoriaService) {

    @PostMapping("/categoria")
    fun createCategoria(@Valid @RequestBody categoriaRequest: CategoriaModel): ResponseEntity<CategoriaModel> {
        return ResponseEntity.ok(
            categoriaService.createCategoria(categoriaRequest))
    }
}
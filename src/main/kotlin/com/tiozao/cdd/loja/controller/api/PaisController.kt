package com.tiozao.cdd.loja.controller.api

import com.tiozao.cdd.loja.domain.model.PaisModel
import com.tiozao.cdd.loja.domain.service.PaisService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PaisController(private var paisService: PaisService) {

    @PostMapping("/pais")
    fun createPais(@RequestBody paisRequest: PaisModel): ResponseEntity<PaisModel> {
        return ResponseEntity.ok(
            paisService.createPais(
                paisRequest))
    }



}
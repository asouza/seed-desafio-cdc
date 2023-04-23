package com.tiozao.cdd.loja.controller.api

import com.tiozao.cdd.loja.controller.extensions.toModel
import com.tiozao.cdd.loja.controller.extensions.toResponse
import com.tiozao.cdd.loja.controller.model.PaisRequest
import com.tiozao.cdd.loja.controller.model.PaisResponse
import com.tiozao.cdd.loja.domain.service.PaisService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PaisController(private var paisService: PaisService) {

    @PostMapping("/pais")
    fun createPais(@RequestBody paisRequest: PaisRequest): ResponseEntity<PaisResponse> {
        return ResponseEntity.ok(
            paisService.createPais(
                paisRequest.toModel())
                .toResponse())
    }



}
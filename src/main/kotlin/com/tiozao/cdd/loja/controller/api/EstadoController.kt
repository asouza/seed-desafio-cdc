package com.tiozao.cdd.loja.controller.api

import com.tiozao.cdd.loja.controller.extensions.toModel
import com.tiozao.cdd.loja.controller.extensions.toResponse
import com.tiozao.cdd.loja.controller.model.EstadoRequest
import com.tiozao.cdd.loja.controller.model.EstadoResponse
import com.tiozao.cdd.loja.domain.service.PaisService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.websocket.server.PathParam

@RestController
class EstadoController(private var paisService: PaisService) {

    @PostMapping("/pais/{paisNome}/estado")
    fun createEstado(
        @PathVariable("paisNome") paisNome: String,
        @RequestBody estadoRequest: EstadoRequest
    ): ResponseEntity<EstadoResponse> {
        return ResponseEntity.ok(
            paisService.addEstadoToPais(estadoRequest.toModel(paisNome),paisNome)
                .toResponse())
    }
}
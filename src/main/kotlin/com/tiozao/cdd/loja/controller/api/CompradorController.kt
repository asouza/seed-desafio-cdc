package com.tiozao.cdd.loja.controller.api

import com.tiozao.cdd.loja.controller.extensions.ToModel
import com.tiozao.cdd.loja.controller.extensions.toResponse
import com.tiozao.cdd.loja.controller.model.CompradorRequest
import com.tiozao.cdd.loja.controller.model.CompradorResponse
import com.tiozao.cdd.loja.domain.service.CompradorService
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@Validated
class Compradorontroller(private var compradorService: CompradorService) {

    @PostMapping("/comprador")
    fun createComprador(@Valid @RequestBody compradorRequest: CompradorRequest): ResponseEntity<CompradorResponse> {
        return ResponseEntity.ok(compradorService
            .createComprador(
                compradorRequest.ToModel())
            .toResponse())
    }

}
package com.tiozao.cdd.loja.controller.api

import com.tiozao.cdd.loja.controller.extensions.toModel
import com.tiozao.cdd.loja.controller.extensions.toResponse
import com.tiozao.cdd.loja.controller.model.CarrinhoCompraResponse
import com.tiozao.cdd.loja.controller.model.CarrinhoCompraRequest
import com.tiozao.cdd.loja.domain.service.CarrinhoCompraService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import javax.validation.Valid

@RestController
class CarrinhoCompraController(private var carrinhoCompraService: CarrinhoCompraService) {

    @PostMapping("/compra/{idComprador}")
    fun createCarrinhoCompra(
        @PathVariable(name = "idComprador", required = true ) idComprador: Int,
        @RequestBody @Valid carrinhoCompra: CarrinhoCompraRequest): ResponseEntity<CarrinhoCompraResponse> {
        return ResponseEntity.ok(
            carrinhoCompraService
                .createCarrinhoCompra(
                    carrinhoCompra.toModel(idComprador))
                .toResponse())
    }
}
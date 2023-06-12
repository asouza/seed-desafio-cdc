package com.tiozao.cdd.loja.controller.api

import com.tiozao.cdd.loja.domain.model.CarrinhoCompraModel
import com.tiozao.cdd.loja.domain.model.validators.EstadoPertencePais
import com.tiozao.cdd.loja.domain.service.CarrinhoCompraService
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.InitBinder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
@Validated
class CarrinhoCompraController(
    private var carrinhoCompraService: CarrinhoCompraService,
    private var estadoPertenceAPaisValidator: EstadoPertencePais
) {

    @InitBinder
    fun init(binder: WebDataBinder) {
        binder.addValidators(estadoPertenceAPaisValidator)
    }
    @PostMapping("/compra")
    fun createCarrinhoCompra( @RequestBody @Valid carrinhoCompra: CarrinhoCompraModel ): ResponseEntity<CarrinhoCompraModel> {
        return ResponseEntity.ok(
            carrinhoCompraService
                .createCarrinhoCompra(
                    carrinhoCompra)
                )
    }
}
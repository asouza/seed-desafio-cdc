package com.tiozao.cdd.loja.controller.api

import com.tiozao.cdd.loja.domain.model.CupomModel
import com.tiozao.cdd.loja.domain.service.CupomService
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@Validated
class CuporController(private var cupomService: CupomService) {

    @PostMapping("/cupom")
    fun createCupom(@Valid @RequestBody cupomRequest: CupomModel):ResponseEntity<CupomModel> {
        return ResponseEntity.ok(
           cupomService.createCupom(cupomRequest)
        )
    }

}
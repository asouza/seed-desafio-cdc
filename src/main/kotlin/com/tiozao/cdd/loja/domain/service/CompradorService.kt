package com.tiozao.cdd.loja.domain.service

import com.tiozao.cdd.loja.domain.model.CompradorModel
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import javax.validation.Valid

@Service
@Validated
class CompradorService {

    fun createComprador(@Valid compradorModel: CompradorModel): CompradorModel {
        return compradorModel
    }
}
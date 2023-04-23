package com.tiozao.cdd.loja.domain.service

import com.tiozao.cdd.loja.domain.model.EstadoModel
import com.tiozao.cdd.loja.domain.model.PaisModel
import com.tiozao.cdd.loja.repository.EstadoRepository
import com.tiozao.cdd.loja.repository.PaisRepository
import com.tiozao.cdd.loja.repository.extensions.toEntity
import com.tiozao.cdd.loja.repository.extensions.toModel
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import javax.validation.Valid

@Service
@Validated
class PaisService(
    private var paisRepository: PaisRepository,
    private var estadoRepository: EstadoRepository
    ) {

    fun createPais(@Valid paisModel: PaisModel): PaisModel {
        return paisRepository.save(paisModel.toEntity())
            .toModel()
    }

    fun addEstadoToPais(@Valid estadoModel: EstadoModel, paisNome: String): EstadoModel {
        var pais = paisRepository.findByNome(paisNome).get()
        return estadoRepository.save(estadoModel
            .toEntity().copy(pais = pais))
            .toModel()
    }


}
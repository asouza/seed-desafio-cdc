package com.tiozao.cdd.loja.domain.service

import com.tiozao.cdd.loja.domain.model.CompradorModel
import com.tiozao.cdd.loja.repository.CompradorRepository
import com.tiozao.cdd.loja.repository.EstadoRepository
import com.tiozao.cdd.loja.repository.PaisRepository
import com.tiozao.cdd.loja.repository.entity.CompradorEntity
import com.tiozao.cdd.loja.repository.extensions.toEntity
import com.tiozao.cdd.loja.repository.extensions.toModel
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import javax.validation.Valid

@Service
@Validated
class CompradorService(
    private var compradorRepository: CompradorRepository,
    private var paisRepository: PaisRepository,
    private var estadoRepository: EstadoRepository) {

    fun createComprador(@Valid compradorModel: CompradorModel): CompradorModel {
        return compradorRepository.save<CompradorEntity>(
            compradorModel.toEntity(
                paisRepository.findById(compradorModel.paisId).get(),
                compradorModel.estadoId?.let {
                    estadoRepository.findById(it).get()
                }))
                .toModel()
    }

    fun findComprador(idComprador: Int): CompradorModel {
        return compradorRepository.findById(idComprador).get().toModel()
    }
}

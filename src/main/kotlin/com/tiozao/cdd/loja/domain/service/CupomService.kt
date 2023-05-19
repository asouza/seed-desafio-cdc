package com.tiozao.cdd.loja.domain.service

import com.tiozao.cdd.loja.domain.model.CupomModel
import com.tiozao.cdd.loja.repository.CupomRepository
import com.tiozao.cdd.loja.repository.extensions.toEntity
import com.tiozao.cdd.loja.repository.extensions.toModel
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import javax.validation.Valid


@Service
@Validated
class CupomService(private var cupomRepository: CupomRepository) {
    fun createCupom(@Valid cupom: CupomModel): CupomModel {
        return cupomRepository.save(cupom.toEntity()).toModel()
    }

}
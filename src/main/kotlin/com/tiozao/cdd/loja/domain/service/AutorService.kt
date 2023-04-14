package com.tiozao.cdd.loja.domain.service

import com.tiozao.cdd.loja.domain.model.AutorModel
import com.tiozao.cdd.loja.repository.AutorRepository
import com.tiozao.cdd.loja.repository.extensions.toEntity
import com.tiozao.cdd.loja.repository.extensions.toModel
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import javax.validation.Valid


@Service
@Validated
class AutorService(private var autorRepository: AutorRepository) {

    fun createAutor(@Valid autor: AutorModel): AutorModel {
        return autorRepository.save(
            autor.toEntity())
            .toModel()
    }

    fun findAutor(autorId: Int): AutorModel {
        autorRepository.findById(autorId)?.let { return it.get().toModel() }
    }


}
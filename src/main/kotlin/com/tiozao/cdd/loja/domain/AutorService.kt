package com.tiozao.cdd.loja.domain

import com.tiozao.cdd.loja.domain.model.AutorModel
import com.tiozao.cdd.loja.repository.AutorRepository
import jakarta.validation.Valid
import org.springframework.stereotype.Service
import org.springframework.validation.BeanPropertyBindingResult
import org.springframework.validation.Validator


@Service
class AutorService( private var autorRepository: AutorRepository) {

    fun createAutor(@Valid autor: AutorModel): AutorModel {
        return autorRepository.save(autor)
    }
}
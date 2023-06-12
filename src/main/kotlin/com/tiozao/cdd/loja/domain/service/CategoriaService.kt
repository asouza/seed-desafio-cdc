package com.tiozao.cdd.loja.domain.service

import com.tiozao.cdd.loja.domain.model.CategoriaModel
import com.tiozao.cdd.loja.repository.entity.CategoriaEntity
import com.tiozao.cdd.loja.repository.CategoriaRepository
import com.tiozao.cdd.loja.repository.extensions.toEntity
import com.tiozao.cdd.loja.repository.extensions.toModel
import javax.validation.Valid
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated

@Service
@Validated
class CategoriaService(private var repository: CategoriaRepository) {

    fun createCategoria(@Valid categoria: CategoriaModel): CategoriaModel {
        return repository.save(
            categoria.toEntity())
            .toModel()
    }

    fun findCategoria(categoriaId: Int) =
         repository.findById(categoriaId).orElse( null)

}
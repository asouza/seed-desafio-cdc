package com.tiozao.cdd.loja.domain.service

import com.tiozao.cdd.loja.domain.model.LivroModel
import com.tiozao.cdd.loja.repository.AutorRepository
import com.tiozao.cdd.loja.repository.CategoriaRepository
import com.tiozao.cdd.loja.repository.LivroRepository
import com.tiozao.cdd.loja.repository.extensions.toEntity
import com.tiozao.cdd.loja.repository.extensions.toModel
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import javax.validation.Valid

@Service
@Validated
class LivroService(
    private var livroRepository: LivroRepository,
    private var autorRepository: AutorRepository,
    private var categoriaRepository: CategoriaRepository
    ) {

    fun createLivro(@Valid livro: LivroModel): LivroModel{
        return livroRepository.save(livro.toEntity(
            categoriaRepository.findById(livro.categoriaId).get(),
            autorRepository.findById(livro.autorId).get()
        ))
            .toModel()
    }

    fun findLivro(id: Int): LivroModel? {
        return livroRepository.findById(id).get().toModel()
    }

}
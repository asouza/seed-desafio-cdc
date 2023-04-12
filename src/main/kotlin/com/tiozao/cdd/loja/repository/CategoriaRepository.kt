package com.tiozao.cdd.loja.repository

import com.tiozao.cdd.loja.repository.entity.CategoriaEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface CategoriaRepository: CrudRepository<CategoriaEntity,Int>{
    fun findByNome(nome: String): Optional<CategoriaEntity>

}
package com.tiozao.cdd.loja.repository

import com.tiozao.cdd.loja.repository.entity.LivroEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface LivroRepository: CrudRepository<LivroEntity,Int> {
}
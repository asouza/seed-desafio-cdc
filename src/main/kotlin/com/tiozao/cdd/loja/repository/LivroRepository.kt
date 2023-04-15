package com.tiozao.cdd.loja.repository

import com.tiozao.cdd.loja.repository.entity.LivroEntity
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface LivroRepository: PagingAndSortingRepository<LivroEntity,Int> {
}
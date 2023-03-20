package com.tiozao.cdd.loja.repository

import com.tiozao.cdd.loja.domain.model.AutorModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AutorRepository: CrudRepository<AutorModel,Int>{
}
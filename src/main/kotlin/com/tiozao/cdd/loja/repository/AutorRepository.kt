package com.tiozao.cdd.loja.repository

import com.tiozao.cdd.loja.repository.entity.AutorEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface AutorRepository: CrudRepository<AutorEntity,Int>{

    fun findByEmail( email: String ): Optional<AutorEntity>
}
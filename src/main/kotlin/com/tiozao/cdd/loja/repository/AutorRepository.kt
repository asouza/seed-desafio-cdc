package com.tiozao.cdd.loja.repository

import com.tiozao.cdd.loja.domain.model.AutorModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface AutorRepository: CrudRepository<AutorModel,Int>{

    fun findByEmail( email: String ): Optional<AutorModel>
}
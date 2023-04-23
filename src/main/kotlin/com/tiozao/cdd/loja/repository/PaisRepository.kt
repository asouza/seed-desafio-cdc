package com.tiozao.cdd.loja.repository

import com.tiozao.cdd.loja.repository.entity.PaisEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PaisRepository : CrudRepository<PaisEntity, Int> {
    fun findByNome(paisNome: String): Optional<PaisEntity>

}
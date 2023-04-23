package com.tiozao.cdd.loja.repository

import com.tiozao.cdd.loja.repository.entity.EstadoEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface EstadoRepository : CrudRepository<EstadoEntity, Int>{
}
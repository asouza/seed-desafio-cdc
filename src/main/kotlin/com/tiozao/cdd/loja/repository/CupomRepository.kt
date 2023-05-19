package com.tiozao.cdd.loja.repository

import com.tiozao.cdd.loja.repository.entity.CupomEntity
import org.springframework.data.repository.CrudRepository

interface CupomRepository: CrudRepository<CupomEntity, Int> {
}
package com.tiozao.cdd.loja.repository

import com.tiozao.cdd.loja.repository.entity.CompradorEntity
import org.springframework.data.repository.CrudRepository

interface CompradorRepository: CrudRepository<CompradorEntity, Int> {

}
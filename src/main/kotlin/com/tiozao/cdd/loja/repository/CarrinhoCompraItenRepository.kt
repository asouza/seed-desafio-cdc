package com.tiozao.cdd.loja.repository

import com.tiozao.cdd.loja.repository.entity.CarrinhoCompraItemEntity
import org.springframework.data.repository.CrudRepository

interface CarrinhoCompraItenRepository: CrudRepository<CarrinhoCompraItemEntity,Int> {
}
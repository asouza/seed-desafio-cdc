package com.tiozao.cdd.loja.repository

import com.tiozao.cdd.loja.repository.entity.CarrinhoCompraEntity
import org.springframework.data.repository.CrudRepository

interface CarrinhoComprasRepository: CrudRepository<CarrinhoCompraEntity, Int> {

}
package com.tiozao.cdd.loja.repository.entity

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name= "carrinho_compras_itens")
data class CarrinhoCompraItemEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    @field:NotNull
    @field:ManyToOne
    var livro: LivroEntity,
    @ManyToOne
    var carrinhoCompra: CarrinhoCompraEntity?,
    var quantidade: Int )
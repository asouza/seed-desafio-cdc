package com.tiozao.cdd.loja.repository.entity

import java.math.BigDecimal
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name="carrinho_compras")
data class CarrinhoCompraEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    @field:NotNull
    @field:ManyToOne
    var comprador: CompradorEntity,
    var total: BigDecimal,
    @OneToMany
    @JoinColumn(name = "carrinho_compra_id")
    var itens: MutableList<CarrinhoCompraItemEntity>? )
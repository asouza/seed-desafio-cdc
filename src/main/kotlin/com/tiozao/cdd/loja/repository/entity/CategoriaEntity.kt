package com.tiozao.cdd.loja.repository.entity

//import com.tiozao.cdd.loja.domain.model.validators.CategoriaName
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "categoria")
data class CategoriaEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?,

    @field:Column(nullable = false)
    var nome: String?
){
    constructor() : this(null,null) {
    }

}
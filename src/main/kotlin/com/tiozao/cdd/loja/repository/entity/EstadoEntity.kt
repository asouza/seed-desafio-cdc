package com.tiozao.cdd.loja.repository.entity

import javax.persistence.*

@Entity
@Table(name="estado")
data class EstadoEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?,
    var nome: String?,
    var sigla: String?,
    @ManyToOne
    var pais: PaisEntity
    ){

    override fun equals(other: Any?): Boolean {
        if(other is EstadoEntity){
            return other.nome == this.nome && other.sigla == this.sigla
        }
        return super.equals(other)
    }
}

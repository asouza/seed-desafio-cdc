package com.dev.eficiente.casa.codigo

import org.mapstruct.Mapper
import org.mapstruct.Mappings

@Mapper
interface AutorMapper {

    @Mappings
    fun toDomain(autorDTO: AutorDTO): Autor
}
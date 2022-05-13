package com.dev.eficiente.casa.codigo

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import org.springframework.http.ResponseEntity
import javax.validation.Valid


@Controller("/autor")
open class AutorController(
    private val autorService: AutorService,
    private val autorMapper: AutorMapper
) {

    @Post
    open fun salvarAutor(@Valid @Body autor: AutorDTO): ResponseEntity<Autor> =
        autorMapper.toDomain(autor)
            .let { ResponseEntity.ok(autorService.saveAutor(it)) }

}
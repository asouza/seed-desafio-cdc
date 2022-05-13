package com.dev.eficiente.casa.codigo

import jakarta.inject.Singleton

@Singleton
class AutorService(private val autorRepository: AutorRepository) {

    fun saveAutor(autor: Autor): Autor = autorRepository.save(autor)
}
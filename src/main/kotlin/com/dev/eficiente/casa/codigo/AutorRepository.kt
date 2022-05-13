package com.dev.eficiente.casa.codigo

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface AutorRepository : JpaRepository<Autor, Long>
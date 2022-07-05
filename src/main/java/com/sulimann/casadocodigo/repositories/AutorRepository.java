package com.sulimann.casadocodigo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sulimann.casadocodigo.entities.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{
    
}

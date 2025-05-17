package com.Microservicio.GestionDeCursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Microservicio.GestionDeCursos.model.Inscripciones;

@Repository
public interface InscripcionesRepository extends JpaRepository<Inscripciones, Integer>{
    
}

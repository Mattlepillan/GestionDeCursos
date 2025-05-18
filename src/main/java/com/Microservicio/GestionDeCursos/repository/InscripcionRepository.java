package com.Microservicio.GestionDeCursos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Microservicio.GestionDeCursos.model.Inscripcion;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Integer>{

    List<Inscripcion> findAll();
    
    @SuppressWarnings("unchecked")
    Inscripcion save(Inscripcion inscripciones);

    Inscripcion findById(int id);

    Inscripcion getReferenceById(Integer id); 
    
}

package com.Microservicio.GestionDeCursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Microservicio.GestionDeCursos.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{
    
}

package com.Microservicio.GestionDeCursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Microservicio.GestionDeCursos.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>{
    
}

package com.Microservicio.GestionDeCursos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Microservicio.GestionDeCursos.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{

    List<Curso> findAll();
    
    @SuppressWarnings("unchecked")
    Curso save(Curso curso);

    Curso findById(int id);

    Curso getReferenceById(Integer id); 

    void delete(Curso curso);
    
}

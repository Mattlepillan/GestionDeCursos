package com.Microservicio.GestionDeCursos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Microservicio.GestionDeCursos.model.Contenido;

@Repository
public interface ContenidoRepository extends JpaRepository<Contenido, Integer> {

    List<Contenido> findAll();
    
    @SuppressWarnings("unchecked")
    Contenido save(Contenido contenido);
}

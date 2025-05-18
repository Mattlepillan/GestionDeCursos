package com.Microservicio.GestionDeCursos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Microservicio.GestionDeCursos.model.Curso;
import com.Microservicio.GestionDeCursos.repository.CursoRepository;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> listarTodos(){
        return cursoRepository.findAll();
    }

    public Curso save(Curso curso){
        return cursoRepository.save(curso);       
    }

    public Curso findById(int id){
        return cursoRepository.findById(id);
    }
    
    public Curso cursoxId(int id){
        return cursoRepository.getReferenceById(id);
    }
}

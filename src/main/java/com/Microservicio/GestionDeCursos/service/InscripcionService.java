package com.Microservicio.GestionDeCursos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Microservicio.GestionDeCursos.model.Inscripcion;
import com.Microservicio.GestionDeCursos.repository.InscripcionRepository;

@Service
public class InscripcionService {
    @Autowired
    private InscripcionRepository inscripcionRepository;

    public List<Inscripcion> listarTodos(){
        return inscripcionRepository.findAll();
    }

    public Inscripcion save(Inscripcion inscripcion){
        return inscripcionRepository.save(inscripcion);       
    }

    public Inscripcion findById(int id){
        return inscripcionRepository.findById(id);
    }
    
    public Inscripcion cursoxId(int id){
        return inscripcionRepository.getReferenceById(id);
    }

     public void delete(Inscripcion inscripcion){
        inscripcionRepository.delete(inscripcion);
    }
}

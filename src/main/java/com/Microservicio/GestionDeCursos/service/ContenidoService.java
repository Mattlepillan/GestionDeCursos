package com.Microservicio.GestionDeCursos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Microservicio.GestionDeCursos.model.Contenido;
import com.Microservicio.GestionDeCursos.repository.ContenidoRepository;

@Service
public class ContenidoService {
    @Autowired
    private ContenidoRepository contenidoRepository;

    public List<Contenido> listarTodos(){
        return contenidoRepository.findAll();
        
    }

    public Contenido save(Contenido contenido){
        return contenidoRepository.save(contenido); 

    }
    
    public Contenido findById(int id){
        return contenidoRepository.findById(id);
    }

     public Contenido cursoxId(int id){
        return contenidoRepository.getReferenceById(id);
    }

    public void delete(Contenido contenido){
        contenidoRepository.delete(contenido);
    }
}

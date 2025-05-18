package com.Microservicio.GestionDeCursos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Microservicio.GestionDeCursos.model.Contenido;
import com.Microservicio.GestionDeCursos.model.Curso;
import com.Microservicio.GestionDeCursos.service.ContenidoService;
import com.Microservicio.GestionDeCursos.service.CursoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/contenido")
public class ContenidoController {
    @Autowired
    private ContenidoService contenidoService;

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Contenido>> getContenido(){
        List<Contenido> contenidos = contenidoService.listarTodos();
        if (contenidos.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contenidos,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Contenido> postContenido(@RequestBody Contenido contenido){
        int id_link = contenido.getCurso().getCursoId();

        Curso curso = cursoService.cursoxId(id_link);
        if(curso != null)
        {
            contenido.setCurso(curso);

        }
        Contenido nuevo = contenidoService.save(contenido);
        if(nuevo == null)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
        


    }
    
}

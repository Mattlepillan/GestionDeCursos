package com.Microservicio.GestionDeCursos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Microservicio.GestionDeCursos.model.Curso;
import com.Microservicio.GestionDeCursos.model.Inscripcion;
import com.Microservicio.GestionDeCursos.service.CursoService;
import com.Microservicio.GestionDeCursos.service.InscripcionService;


@RestController
@RequestMapping("/api/inscripcion")
public class InscripcionController {
    @Autowired
    private InscripcionService inscripcionService;

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Inscripcion>> getInscripcion(){
        List<Inscripcion> inscripciones = inscripcionService.listarTodos();
        if (inscripciones.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(inscripciones,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Inscripcion> postInscripcion(@RequestBody Inscripcion inscripcion){
        int id_link = inscripcion.getCursos().getCursoId();

        Curso curso = cursoService.cursoxId(id_link);
        if(curso != null)
        {
            inscripcion.setCursos(curso);

        }
        Inscripcion nueva = inscripcionService.save(inscripcion);
        if(nueva == null)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Curso> deleteInscripcion(@PathVariable int id, @RequestBody Inscripcion inscripcion){
        Inscripcion buscado = inscripcionService.findById(inscripcion.getId());
        if(buscado == null)
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else
        {
            inscripcionService.delete(inscripcion);
            return new ResponseEntity<>( HttpStatus.OK);
        }
    }
}
